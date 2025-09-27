package blatt06;

// finale Abgabe

import java.util.Scanner;

public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie den Grad n ein, der zusammen mit den Koeffizienten (an - a0) die Funktion definieren:");
        int n = input.nextInt() + 1;
        StringBuilder formel = new StringBuilder();

        double[] koeffizienten = new double[n];

        for (int i = 0; i < n; i++) { // eingeben & speichern der Koeffizienten
            System.out.println("Bitte geben Sie einen Koeffizienten a zu x^" + (n - (i + 1)) + " an.");
            koeffizienten[n - (i + 1)] = input.nextDouble();
        }

        for (int i = 0; i < koeffizienten.length; i++) { // erstellen der Formel
            formel.append(koeffizienten[n - (i + 1)]).append("x^").append(n - (i + 1));
            if (i < n - 1) {
                formel.append(" + ");
            }
        }
        System.out.println("Das angegebene Polynom lautet: f(x) = " + formel);

        System.out.println("\nAb welcher Stelle wollen Sie sich die Werte des Polynoms ausgeben lassen? (Untergrenze)");
        int u = input.nextInt();
        System.out.println("Bis zu welcher Stelle wollen Sie sich die Werte des Polynoms ausgeben lassen? (Obergrenze)");
        int o = input.nextInt();

        if (u > o) {
            int x = u;
            u = o;
            o = x;
        }

        System.out.println("In wie großen Schritten sollen die Werte angegeben werden?");
        double s = Math.abs(input.nextDouble());
        while (s == 0) {
            System.out.println("Bitte geben Sie für die Schrittgröße nicht 0 ein!");
            s  = input.nextDouble();
        }

        double[] stellen = new double[(int) ((o - u) / s) + 1];
        double[] werte = new double[(int) ((o - u) / s) + 1];

        System.out.println("Stelle:\tWert:");
        for (int i = 0; i < werte.length; i ++) {
            stellen[i] = i * s + u;
            werte[i] = 0;
            for (int j = 0; j < koeffizienten.length; j++) {
                werte[i] += koeffizienten[j] * Math.pow(stellen[i], j);
            }
            if (stellen[i] <= 10000 && stellen[i] >= 1000) {
                System.out.printf("%.2f\t\t%.2f%n", stellen[i], werte[i]);
            }
            else {
                System.out.printf("%.2f\t%.2f%n", stellen[i], werte[i]);
            }
        }
    }
}