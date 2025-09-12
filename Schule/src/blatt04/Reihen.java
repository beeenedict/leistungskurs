package blatt04;

import java.util.Scanner;

public class Reihen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int reihe = 1;
        int n = 1;

        System.out.println("Wie viele Zahlen möchten Sie je Reihe ausgegeben bekommen?");
        int laenge = -input.nextInt();
        int l = laenge;

        while (reihe < 5) { // ausgeben der Reihen
            System.out.println("Reihe " + reihe + ":");

            while (laenge < 0) { // ausgeben der Folgenglieder

                if (reihe == 1) {
                    System.out.printf("%d ", n);
                }
                else if (reihe == 2) {
                    System.out.printf("%d ", 2 * n);
                }
                else if (reihe == 3) {
                    System.out.printf("%d ", n * n);
                }
                else {
                    System.out.printf("%d ", (((n + 1) / 2) * (int) Math.pow(-1, n-1)));
                }
                n++;
                laenge++;
            }
            if (reihe != 4) { //Formatierung
                System.out.println("\n");
            }
            laenge = l; // zurücksetzen der Variablen die je Folge benötigt werden
            n = 1;
            reihe++;
        }
    }
}
