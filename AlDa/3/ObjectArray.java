/** Array-basierte Liste f¨ur Daten vom Typ Object */
public class ObjectArray {
	/** Datenspeicher */
	Object[] array;
	/** Anzahl der belegten Eintr¨age */
	int belegt;
	/** Konstruktor f¨ur eine leere Liste
	*
	* @param maxsize Maximale Gr¨oße
	*/
	public ObjectArray(int maxsize) {
		array = new Object[maxsize];
		belegt = 0;
	};
	/** Direktzugriff auf ein Element */
	public Object get(int position) {
		return array[position];
	}
	/** L¨ange der Liste. */
	public int size() {
		return belegt;
	}
	/** Element am Ende einf¨ugen */
	public void append(Object daten) {
		if (belegt == array.length) {
			throw new ArrayIndexOutOfBoundsException("Liste ist voll.");
		}
		array[belegt] = daten;
		belegt++;
	}
	/** Element am Anfang einf¨ugen */
	public void prepend(Object daten) {
		if (belegt == array.length) {
			throw new ArrayIndexOutOfBoundsException("Liste ist voll.");
		}
		belegt++;
		Object prev = daten;
		for (int i = 0; i < belegt; i++){
			Object tmp = array[i];
			array[i] = daten;
			daten = tmp;
		}
	}

	@Override
	public String toString(){
		String res = "";
		for(int i = 0; i < belegt; i++){
			res += array[i];
		}
		return res;
	}

	public static void main(String[] args) {
		ObjectArray a = new ObjectArray(20);
		a.append(5);
		a.append(5);
		a.append(5);
		a.prepend(4);
		System.out.println(a.toString());
	}
}