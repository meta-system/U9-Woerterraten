import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class WoerterRaten {
    public static void main(String[] args) throws IOException {
        Wort[] woerter = einlesen("beispiel.txt");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Anzahl der Aktionen:");
        int aktionZahl = Integer.parseInt(in.readLine());
        int cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
        woerter[cur].neuerVersuch();
        String antwort;
        char temp;
        do{
            aktionZahl--;
            System.out.println(woerter[cur].toString());
            System.out.println("Noch " + aktionZahl + " Aktionen.");
        	System.out.println("Wollen Sie aufgeben (a), loesen (l), oder Buchstaben raten (r)?");
        	//temp =  in.readLine().charAt(0);
        	temp= in.readLine().charAt(0);
            switch (temp){
        		case 'a':
        		    woerter[cur].aufloesen();
        		    System.out.println(woerter[cur].toString());
                    cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                    woerter[cur].neuerVersuch();
                    break;
        		case 'l':
                    System.out.println("Wie lautet das Wort?");
        			antwort = in.readLine();
        			if (woerter[cur].aufloesen(antwort)){
        				System.out.println("Richtig");
                        cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                        woerter[cur].neuerVersuch();
                    } else {
                        System.out.println("Falsch!");
        			}
        			break;
        		case 'r':
                    System.out.println("Welches Zeichen wählen Sie?");
                    System.out.print("Das Zeichen kam " + woerter[cur].rateZeichen(in.readLine().charAt(0)) + " mal vor.");
        		    if(woerter[cur].geloest()){
                        System.out.println(woerter[cur].toString());
                        cur = ThreadLocalRandom.current().nextInt(0, woerter.length-1);
                        woerter[cur].neuerVersuch();
                    }
        			break;
                default:
                    System.out.println("Bitte richtige Eingabe.");
                    aktionZahl++;
        			break;
        	}
        } while (aktionZahl>1);

        System.out.println("S t a t i s t i k  ( Anzahl  Versuche  :  Anzahl  e r f o l g r e i c h e r  Versuche > gesuchtes  Wort )");
        woerter = iSort(woerter);
        for (int i = 0; i < woerter.length ;i++){
            System.out.print(woerter[i].getAnzahlVersuche() + " : " + woerter[i].getAnzahlLoesungen() + " -> " + woerter[i].getWort());
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

    public static Wort[] iSort(Wort [] array){
        Wort temp;
        for (int i = 0; i < array.length; i++){
            temp = array[i];
            for (int j = (i-1); 0 <= j; j--){
                if (array[j].compareTo(temp) > 0){
                    array[j+1] = array[j];
                    if (j == 0){
                        array[j]=temp;
                    }
                } else {
                    array[j+1] = temp;
                    //j = 0;
                    break;
                }
            }
        }
        return array;
    }


}
