package blatt04;

import java.util.Random;
import java.util.Scanner;

public class ETFErweitert {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        double sparBetrag;
        double gesamtBetrag = 0;
        double msciAnteil = 3578.89;
        double anteil;
        double zinssatz;
        int monat = 0;
        int jahr = 0;

        System.out.println("Wieviele Jahre möchten Sie sparen?");
        int anzahlJahre = input.nextInt();

        while (jahr < anzahlJahre) {

            System.out.println("Welchen monatlichen Sparbetrag nöchten Sie für dieses Jahr festlegen?");
            sparBetrag = input.nextDouble();

            System.out.println("Jahr:\tMonat:\tZinssatz: (%)\tGesamtbetrag (€):\tMSCI-Anteil: (%)\t");

            while (monat < 12) {

                zinssatz = (random.nextDouble() + 1) * 6;
                gesamtBetrag += sparBetrag;
                gesamtBetrag *= 1 + (zinssatz / 100);
                anteil = gesamtBetrag / msciAnteil * 100;

                System.out.printf(" %d\t\t%d\t\t%.2f\t\t\t%.2f\t\t\t\t%.5f%n", (jahr + 1), (monat + 1), zinssatz, gesamtBetrag, anteil);

                monat++;
            }
            monat = 0;
            jahr++;
        }
    }
}
