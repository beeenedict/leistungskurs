package blatt06;

import java.util.Scanner;

public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie den Grad n ein, der zusammen mit den Koeffizienten (an - a0) die Funktion definieren:");
        int n = input.nextInt();
        String formel = "";

        double[] koeffizienten = new double[n];

        for (int i = 0; i < n; i++) { // eingeben & speichern der Koeffizienten
            System.out.println("Bitte geben Sie einen Koeffizienten a zu x^" + (n - (i + 1)) + " an.");
            koeffizienten[n - (i + 1)] = input.nextDouble();
        }

        for (int i = 0; i < koeffizienten.length; i++) { // erstellen der Formel
            formel += koeffizienten[n - (i + 1)] + "x^" + (n - (i + 1));
            if (i < n - 1) {
                formel += " + ";
            }
        }
        System.out.println("Das angegebene Polynom lautet: f(x) = " + formel); // In der ausgegebenen Formel werden Dezimalzahlen mit "." statt mit "," als Dezimaltrenner ausgegeben, da die doubles zum String addiert werden, dabei nicht angepasst und bei der Ausgabe entsprechend auch keine doubles mehr sind

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
        int s = input.nextInt();
        if (s <= 0) {
            System.out.println("Geben Sie für den Abstand zwischen ausgegebenen Werten bitte eine positive Zahl an.");
        }

        double[] werte = new double[o - u + 1];

        for (int i = 0; i < werte.length; i += s) {
            werte[i] = 0;
            for (int j = 0; j < koeffizienten.length; j++) {
                werte[i] += koeffizienten[j] * Math.pow(i + u, j);
            }
            if (i + u < 1000 && i + u > -100) { // Stellen mit 6 oder weniger Ziffern (bzw. negative Stellen mit 5 oder weniger Ziffern) werden richtig eingerückt, bei hohen 7-stelligen Stellen wird das Integer-Limit zum Problem.
                System.out.println(i + u + "\t\t" + werte[i]);
            }
            else {
                System.out.println(i + u + "\t" + werte[i]);
            }
        }
    }
}