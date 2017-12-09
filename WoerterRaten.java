import java.io.*;
public class WoerterRaten {
    public static void main(String[] args) throws IOException {
        Wort[] woerter = einlesen("beispiel.txt");
    }
    public static Wort[] einlesen(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int anzahl = Integer.parseInt(in.readLine());
        Wort[] woerter = new Wort[anzahl];
        for(int i=0; i<anzahl; i++) {
            woerter[i] = new Wort(in.readLine());
        }
        return woerter;
    }
}
