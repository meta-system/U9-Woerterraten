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
}
