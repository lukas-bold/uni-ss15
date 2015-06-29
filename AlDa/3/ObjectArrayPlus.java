import java.util.*;

/** Array-basierte Liste fuer Daten vom Typ Object */
public class ObjectArrayPlus extends ObjectArray implements Iterable<Object> {
  /** Konstruktor fuer eine leere Liste
   *
   * @param maxsize Maximale Groesse
   */
  public ObjectArrayPlus(int maxsize) {
    super(maxsize);
  };

  /** Element aus Liste entfernen */
  public void remove(int idx) {
    Iterator<Object> iter = new Iter();
    iter.position = idx;
    while (iter.hasNext()) {
      super.array[position] = iter.next();
    }
  }

  /** Einen Iterator fuer die Liste erzeugen */
  public Iterator<Object> iterator() {
    return new Iter();
  }

  /** Implementierung eines Iterators */
  public class Iter implements Iterator<Object> {
    /** Aktuelle Position */
    int position;

    /** Konstruktur */
    public Iter() {
      position = 0;
    }

    /** Zum naechsten Element gehen */
    public Object next() {
      position++;
      return get(position);
    }

    /** Test, ob die Liste ein naechstes Element hat */
    public boolean hasNext() {
      return get(position +1) != null;
    }

    /** Entfernen nicht erlaubt. */
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  /** Methode zum Testen der Implementierung */
  // Hinweis: in der Praxis wuerde man hier einen Unit-Test verwenden!
  public static void main(String[] args) {
    ObjectArray liste = new ObjectArray(10);
    liste.prepend(2);
    liste.prepend(1);
    liste.append(3);
    liste.append(4);
    liste.prepend(0);
    System.out.println("Ist die Laenge 5? "+liste.size());
    System.out.println("Die naechstes Zeile sollte dies sein: '0 1 2 3 4'!");
    for (Object i : liste) {
      System.out.print(i+" ");
    }
    System.out.println();
    System.out.println("Die naechste Zeile sollte leer sein, aber keinen Fehler verursachen!");
    for (Object i : new ObjectArray(10)) {
      System.out.print(i+" ");
    }
    System.out.println();

    remove(3);
    
    System.out.println(super.toString());
  }
}