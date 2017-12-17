import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class WoerterRaten {
    public static void main(String[] args) throws IOException {
        Wort[] woerter = einlesen("beispiel.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Anzahl der Aktionen:");
        int aktionZahl = Integer.parseInt(in.readLine());
        int cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
        String antwort;
        boolean victory  =false;
        char temp;
        do{
            aktionZahl--;
            System.out.println(woerter[cur].toString());
            //System.out.println(aktionZahl);
        	System.out.println("Wollen Sie aufgeben (a), loesen (l), oder Buchstaben raten (r)?");
        	//temp =  in.readLine().charAt(0);
        	temp= in.readLine().charAt(0);
            switch (temp){
        		case 'a':
        		    woerter[cur].aufloesen();
        		    System.out.println(woerter[cur].toString());
                    cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                    break;
        		case 'l':
                    System.out.println("Wie lautet das Wort?");
        			antwort = in.readLine();
        			if (woerter[cur].aufloesen(antwort)){
        				System.out.println("Richtig");
                        cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                    } else {
                        System.out.println("Falsch!");
        			}
        			break;
        		case 'r':
                    System.out.println("I am in r");
                    woerter[cur].neuerVersuch(in.readLine().charAt(0));
        		    if(woerter[cur].geloest()){
                        cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                    }
        			break;
                default:
                    System.out.println("Bitte richtige Eingabe.");
                    aktionZahl++;
        			break;
        	}
        } while (aktionZahl>0);
        
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

    public static String getWord () throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
