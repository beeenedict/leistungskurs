package blatt05;

import java.util.Scanner;

public class NotenlisteMitArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double durchschnitt = 0;

        System.out.println("Bitte geben Sie die Anzahl der Schüler im Kurs an.");
        int anzSchueler = input.nextInt();
        int[] noten = new int[anzSchueler];

        System.out.println("Bitte geben Sie " + anzSchueler + " Note(n) (1-6) ein:");
        for (int i = 0; i <= noten.length - 1; i++) {
            noten[i] = input.nextInt();
        }

        for (int i = 0; i <= noten.length - 1; i++) {
            System.out.println((i + 1) + ". Note: "  + noten[i]);
        }

        System.out.println();

        for (int i = noten.length; i > 0; i--) {
            System.out.println(i + ". Note: " + noten[i-1]);
            durchschnitt += noten[i-1];
        }
        durchschnitt /= noten.length;
        System.out.printf("\nNotendurchschnitt: %.2f", durchschnitt);
    }
}
