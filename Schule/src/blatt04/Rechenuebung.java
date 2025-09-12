package blatt04;

import java.util.Scanner;

public class Rechenuebung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie zwei Faktoren ein und errechnen Sie das Produkt.");

        System.out.println("Faktor 1:");
        double f1 = input.nextDouble();
        System.out.println("Faktor 2:");
        double f2 = input.nextDouble();

        double loesung = f1 * f2;
        double versuch = loesung + 1; // Initialisierung von Variable versuch, damit Bedingung überprüft werden kann, aber zuerst immer versuch != loesung gilt.

        while (versuch != loesung) {

            System.out.printf("Gebe die Lösung von %.1f * %.1f ein.\n", f1, f2);
            versuch = input.nextDouble();

        }

        System.out.printf("Gut! Die Lösung ist %.1f!", versuch);
    }
}
