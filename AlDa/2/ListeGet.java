import java.util.Iterator;

/** Unterklasse, mit index-basiertem Zugriff */
public class ListeGet<INHALT> extends Liste<INHALT> {
  /** Konstruktor fuer eine leere Liste */
  public ListeGet() {
    super();
  };

  /* Element an Position pos (beginnend bei 0) suchen. */
  public INHALT get(int pos) {
    Iterator<INHALT> iter = super.iterator();
    INHALT res = super.kopf.daten;
    for (int i = 0; i <= pos; i++){
      if (iter.hasNext()){
        res = iter.next();
      } else {
        return null;
      }
    }
    return res;
  }

  /** Methode zum Testen der Implementierung */
  public static void main(String[] args) {
    ListeGet<Integer> liste = new ListeGet<Integer>();
    liste.prepend(2);
    liste.prepend(1);
    liste.append(3);
    liste.append(4);
    liste.prepend(0);
    System.out.println("Element position 2: "+liste.get(2)+ " soll: 2");
    System.out.println("Element position 5: "+liste.get(5)+ " soll: null");
  }
}