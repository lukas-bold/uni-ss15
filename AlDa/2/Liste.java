import java.util.*;

/** Verkettete Liste fuer Daten vom Typ INHALT */
public class Liste<INHALT> implements Iterable<INHALT> {
  /** Kopf der Liste */
  Knoten<INHALT> kopf;

  /** Konstruktor fuer eine leere Liste */
  public Liste() {
    kopf = null; // Leer
  };

  /** Laenge der Liste berechnen */
  public int size() {
    int antwort = 0;
    Knoten<INHALT> aktuell = kopf;
    while(aktuell != null) {
      aktuell = aktuell.naechstes;
      antwort += 1;
    }
    return antwort;
  }

  /** Element am Anfang einfuegen */
  public void prepend(INHALT daten) {
    kopf = new Knoten<INHALT>(daten, kopf);
  }

  /** Element am Ende einfuegen */
  public void append(INHALT daten) {
    // Sonderfall: leere Liste
    if (kopf == null) {
      kopf = new Knoten<INHALT>(daten, kopf);
      return;
    }
    Knoten<INHALT> ende = kopf;
    // Das Ende hat kein naechstes Element:
    while(ende.naechstes != null) {
      ende = ende.naechstes;
    }
    ende.naechstes = new Knoten<INHALT>(daten, null);
  }

  /** Klasse, die ein Element der Liste speichert */
  protected static class Knoten<INHALT> {
    /** Gespeichterte Daten */
    protected INHALT daten;

    /** Naechstes Element */
    protected Knoten<INHALT> naechstes;

    /** Konstruktor fuer Knoten */
    public Knoten(INHALT daten, Knoten<INHALT> naechstes) {
      this.daten = daten;
      this.naechstes = naechstes;
    }
  }

  /** Einen Iterator fuer die Liste erzeugen */
  public Iterator<INHALT> iterator() {
    return new Iter<INHALT>(kopf);
  }

  /** Implementierung eines Iterators */
  protected static class Iter<INHALT> implements Iterator<INHALT> {
    /** Aktuelle position */
    Knoten<INHALT> position;

    /** Konstruktur */
    public Iter(Knoten<INHALT> position) {
      this.position = position;
    }

    /** Zum naechsten Element gehen */
    public INHALT next() {
      INHALT ret = position.daten;
      position = position.naechstes;
      return ret;
    }

    /** Test, ob die Liste ein naechstes Element hat */
    public boolean hasNext() {
      return position != null;
    }

    /** Entfernen nicht erlaubt. */
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  /** Methode zum Testen der Implementierung */
  public static void main(String[] args) {
    Liste<Integer> liste = new Liste<Integer>();
    liste.prepend(2);
    liste.prepend(1);
    liste.append(3);
    liste.append(4);
    liste.prepend(0);
    System.out.println("Ist die Laenge 5? "+liste.size());
    System.out.println("Die naechstes Zeile sollte dies sein: '0 1 2 3 4'!");
    for (Integer i : liste) {
      System.out.print(i+" ");
    }
    System.out.println();
    System.out.println("Die naechste Zeile sollte leer sein, aber keinen Fehler verursachen!");
    for (Integer i : new Liste<Integer>()) {
      System.out.print(i+" ");
    }
    System.out.println();
  }
}