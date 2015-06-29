
/** Verkettete Liste fuer Daten vom Typ Integer */
public class IntegerListe extends Liste<Integer> {
	
	
	// Spezialisierung, 
	// -> damit ausschliesslich Integer in der Liste abgelegt werden koennen. 
	// -> Verwendung des Raw-Types haeufig problematisch
	
	
  /** Konstruktor fuer eine leere Liste */
  public IntegerListe() {
    super();
  };

  /** Kleinstes Element der Liste suchen */
  public Integer min() {
	  int min = super.kopf.daten;
	  for (int i : this){
		 if (min > i){
			 min = i;
		 }
	 }
	    return min;
  }

  /** Groesstes Element der Liste suchen */
  public Integer max() {
	 int max = super.kopf.daten;
	 for (int i : this){
		 if (max < i){
			 max = i;
		 }
	 }
    return max;
  }

  /** Methode zum Testen der Implementierung */
  public static void main(String[] args) {
    IntegerListe liste = new IntegerListe();
    liste.append(2);
    liste.append(1);
    liste.append(3);
    liste.append(4);
    liste.append(0);
    System.out.println("Das Minimum ist: "+liste.min()+" erwartet: 0");
    System.out.println("Das Maximum ist: "+liste.max()+" erwartet: 4");
  }
}