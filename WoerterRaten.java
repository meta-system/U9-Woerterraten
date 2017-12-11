import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class WoerterRaten {
    public static void main(String[] args) throws IOException {
        Wort[] woerter = einlesen("beispiel.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        System.out.println("Anzahl der Aktionen:");
        int aktionZahl = Integer.parseInt(in.readLine());
        int randomNum = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
        System.out.println(woerter[randomNum].toString());
        char temp;
        do{
        	System.out.print("Wollen Sie aufgeben (a), loesen (l), oder Buchstaben raten (r)?");
        	temp = in.read();
        	switch (temp){
        		case 'a': //Reset
        			break;
        		case 'l':
        			System.out.print("Wie lautet das Wort?");
        			if (woerter[randomNum].aufloesen(in.read()){
        				System.out.println("Richtig
        			} else {
        			
        			}
        			break;
        		case 'r':
        			//usw
        			break;
        		default:
        			break;
        	}
        }
        
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
