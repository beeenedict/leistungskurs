package blatt06;

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

        while (u >= o) {
            System.out.println("Bitte geben Sie eine Obergrenze an, die über der Untergrenze liegt.");
            System.out.println("Untergrenze:");
            u = input.nextInt();
            System.out.println("Obergrenze:");
            o = input.nextInt();
        }

        System.out.println("In wie großen Schritten sollen die Werte angegeben werden?");
        double s = input.nextDouble();
        if (s <= 0) {
            System.out.println("Geben Sie für den Abstand zwischen ausgegebenen Werten bitte eine positive Zahl an.");
        }

        double[] stellen = new double[(int) ((o - u) / s) + 1];
        double[] werte = new double[(int) ((o - u) / s) + 1];

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