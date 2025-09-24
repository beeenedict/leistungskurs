package blatt06;

import java.util.Random;
import java.util.Scanner;

public class PraefixSummen {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie die Menge der erhobenen Messwerte an.");
        int n = input.nextInt();

        while (n <= 0) {
            System.out.println("Bitte geben Sie eine positive Menge an Messwerten an.");
            n = input.nextInt();
        }

        double[] x = new double[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextDouble();
        }

        double[] prae = new double[n + 1]; // b)
        for (int i = 0; i < prae.length; i++) {
            prae[i] = 0;
            for (int j = 0; j < i; j++) {
                prae[i] += x[j];
            }
        }

        double[] schaetz = new double[n]; // a)
        for (int i = 0; i < schaetz.length - 3; i++) {
            //schaetz[i] = (x[i] + x[i + 1] + x[i + 2] + x[i + 3])/4; // Berechnungsweise 1
            schaetz[i] = (prae[i + 4] - prae[i])/4; // Berechnungsweise 2
        }

        // c) Berechnungsweise 2 bedeutet einen geringeren Berechnungsaufwand da zwei Rechnungen weniger vorgenommen werden müssen, unter der Bedingung, dass der Array prae[n] bereits vorliegt.
        //    Liegt prae[n] nicht vor ist B1 effizienter, da sonst in B2 erst die Werte prae[i+4] und prae[i] errechnet werden müssten, was einen deutlich höheren Berechnungsaufwand bedeuten würde.

        System.out.println("\nMesswerte:\t\t\t\tSchätzwerte:\t\t\tPraefixsumme:");
        for (int i = 0; i < n; i++) {
            System.out.printf("\n%.18f\t%.18f\t%.18f", x[i], schaetz[i], prae[i]);
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t" + prae[n]);
    }
}
