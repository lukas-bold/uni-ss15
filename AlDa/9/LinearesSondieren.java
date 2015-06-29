package Uni.AlDa;


public class LinearesSondieren {
    /** Speicher */
    private int[] daten;

    /** Reservierter Wert */
    private static final int FREE = Integer.MIN_VALUE;

    /** Exception, falls die Tabelle voll ist */
    public static class FullException extends RuntimeException {
        /** Constructor */
        public FullException() {
            super("Tabelle ist voll.");
        }
    }

    /** Constructor
     * @param size Tabellengroesse
     */
    public LinearesSondieren(int size) {
        this.daten = new int[size];
        java.util.Arrays.fill(this.daten, FREE);
    }

    /* Aktuellen Inhalt ausgeben (Debug) */
    private void output() {
        for(int i : daten) {
            System.out.print(i == FREE ? "___ " : String.format("%3d ", i));
        }
        System.out.println();
    }

    /* Einfache Hashfunktion. Nicht besonders gut! */
    private int hash(int val) {
        val = val % daten.length;
        // Vorsicht: Java Modulo kann negative Werte liefern!
        return (val < 0) ? (val + daten.length) : val;
    }

    /* Einen Schluessel in die Hashtabelle einfuegen */
    public void insert(int val) {
        if (val == FREE) { // Sonderfall verbieten
            throw new RuntimeException("Der Schluessel "+FREE
                    + " darf in dieser Implementierung nicht verwendet werden!");
        }
        final int h = hash(val);
        int i = 0;
        int a = h;
        while (daten[a] != FREE) {
            if (daten[a] == val)
                return;
            a = hash(h + (++i));
            if (i >= daten.length) {
                throw new FullException();
            }

        }
        daten[a] = val;
    }

    /** Schluessel in der Tabelle suchen */
    public boolean contains(int val) {
        final int h = hash(val);
        int i = 0;
        int a = h;
        while (val == FREE || daten[a] != FREE) {

            a = hash(a + i);

            if (daten[a] == val)
                return true;

            if (i >= daten.length)
                break;

            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        LinearesSondieren htable = new LinearesSondieren(5);
        htable.insert(2);
        htable.insert(51);
        htable.insert(7);
        htable.insert(7);
        System.out.println(htable.contains(FREE));
        System.out.println(htable.contains(2));
        htable.output();




    }
}
