import java.util.Arrays;

public class Wort {
    // das zu erratende Wort
    private String wort;
    // Anzahl der Versuche das Wort zu erraten
    private int anzahlVersuche;
    // Anzahl der Versuche, die zu einer Loesung fuehrten
    private int anzahlLoesungen;
    // false an Stelle i wenn das i-te Zeichen noch nicht gefunden
    // wurde, ansonsten true
    private boolean[] gefundeneZeichen;
    // Anzahl bisher gefundener Zeichen
    private int anzahlGefundeneZeichen;
    // true wenn das Wort gefunden wurde, ansonsten false
    private boolean statusGeloest;

    public Wort(String wort) {
        this.wort = wort;
        anzahlVersuche = 0;
        anzahlLoesungen = 0;
        gefundeneZeichen = new boolean[wort.length()];
        anzahlGefundeneZeichen = 0;
        statusGeloest = false;
    }
	
	//setzt Status zurück
	public void neuerVersuch(){
    	statusGeloest = false;
    	anzahlGefundeneZeichen = 0;
		Arrays.fill(gefundeneZeichen, false);
	}
	public int rateZeichen(char input) {
    	int count = 0;
		anzahlVersuche++;
		for (int i = 0 ; i < wort.length(); i++){
			if (input == wort.charAt(i)){
				anzahlLoesungen++;
				gefundeneZeichen[i] = true;
				anzahlGefundeneZeichen++;
				count++;
			}
		}
		return count;
	}
	
	public String toString () {
		String myString = "";
		for (int i = 0; i < wort.length(); i++){
			myString += (gefundeneZeichen[i]) ? wort.charAt(i) : "_";
			myString += " ";
		}
		return myString;
	}

	public boolean aufloesen(String versuch){
		if (wort.equals(versuch)){
			statusGeloest = true;
			return true;
		} else {
			statusGeloest = false;
			return false;
		}
	}
	public String aufloesen(){
    	for (int i = 0; i< gefundeneZeichen.length; i++){
    		gefundeneZeichen[i]  = true;
		}
		return wort.toString();
	}
	public boolean geloest(){
		for (int i = 0; i < gefundeneZeichen.length; i++){
			if (!gefundeneZeichen[i]){
				statusGeloest =false;
				return false;
			}
		}
		statusGeloest = true;
		return true;
	}
	public int getAnzahlVersuche(){
		return anzahlVersuche;
	}
	public int getAnzahlLoesungen(){
		return anzahlLoesungen;
	}
	public int compareTo(Wort myWort){
		if (anzahlVersuche > myWort.getAnzahlVersuche()) {
			return 1;
		} else if (anzahlVersuche == myWort.getAnzahlVersuche()) {
			return  (anzahlLoesungen> myWort.anzahlLoesungen) ? 1 : 0;
		} else {
			return -1;
		}
	}

	public String getWort() {
		return wort;
	}
}
