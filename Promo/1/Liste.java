import java.util.*;

/* Verkettete Liste für Daten vom Typ INHALT */
public class Liste<INHALT> implements Iterable<INHALT> {
  /* Kopf der Liste */
  Knoten<INHALT> kopf;

  /* Konstruktor für eine leere Liste */
  public Liste() {
    kopf = null; // Leer
  };

  /* Länge der Liste berechnen */
  public int size() {
    Knoten<INHALT> cursor = kopf;
    int i = 0;
    while (cursor != null) {
      i++;
      cursor = cursor.naechstes;
    }
    return i;
  }

  /* Element am Anfang einfügen */
  public void prepend(INHALT daten) {
    kopf = new Knoten<INHALT>(daten, kopf);
  }

  /* Element am Ende einfügen */
  public void append(INHALT daten) {
    Knoten<INHALT> cursor = kopf;
    while (cursor.naechstes != null) {
      cursor = cursor.naechstes;
    }
    cursor.naechstes = new Knoten<INHALT>(daten, null);
  }

  /* Klasse, die ein Element der Liste speichert */
  protected static class Knoten<INHALT> {
    /* Gespeichterte Daten */
    protected INHALT daten;

    /* Nächstes Element */
    protected Knoten<INHALT> naechstes;

    /* Konstruktor für Knoten */
    public Knoten(INHALT daten, Knoten<INHALT> naechstes) {
      this.daten = daten;
      this.naechstes = naechstes;
    }
  }

  /* Einen Iterator für die Liste erzeugen */
  public Iterator<INHALT> iterator() {
    return new Iter<INHALT>(kopf);
  }

  /* Implementierung eines Iterators */
  public static class Iter<INHALT> implements Iterator<INHALT> {
    /* Aktuelle position */
    Knoten<INHALT> position;

    /* Konstruktur */
    public Iter(Knoten<INHALT> position) {
      this.position = position;
    }

    /* Zum nächsten Element gehen */
    public INHALT next() {
      if (this.hasNext()){
        this.position = this.position.naechstes;
        return this.position.daten;
      } else {
        return null;
      }
    }

    /* Test, ob die Liste ein nächstes Element hat */
    public boolean hasNext() {
      return position.naechstes != null;
    }

    /* Entfernen nicht erlaubt. */
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  /* Methode zum Testen der Implementierung */
  public static void main(String[] args) {
    Liste<Integer> liste = new Liste<Integer>();
    liste.prepend(2);
    liste.prepend(1);
    liste.append(3);
    liste.append(4);
    liste.prepend(0);
    System.out.println("Ist die Länge 5? "+liste.size());
    System.out.println("Die nächstes Zeile sollte dies sein: '0 1 2 3 4'!");
    for (Integer i : liste) {
      System.out.print(i+" ");
    }
    System.out.println();
    System.out.println("Die nächste Zeile sollte leer sein, aber keinen Fehler verursachen!");
    for (Integer i : new Liste<Integer>()) {
      System.out.print(i+" ");
    }
    System.out.println();
  }
}

