package blatt02;

import java.util.Scanner;

public class AmiiboKostenRechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double preisAmiiboFigur = 15.0;
        System.out.println("Wie viele Amiibo-Figuren möchten Sie kaufen?");
        int anzahl = input.nextInt(); //TODO: Einsschränken des Inputs auf ausschließlich nichtnegative Zahlen.
        /*
        if(anzahl < 0){
            anzahl *= -1;
        }
        */
        System.out.printf("Der Gesamtpreis Ihres Einkaufs beträgt %.2f €",  preisAmiiboFigur * anzahl);

    }
}
