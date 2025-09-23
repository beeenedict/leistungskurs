package blatt06;

import java.util.Scanner;

public class DartMitFreunden {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Erzeuge Scanner

        int wuerfe = 0;
        int wurf = 0;


        System.out.println("Wieviele Spieler nehmen Teil.");
        int anzahlSpieler = input.nextInt();
        int sieger = 0;
        boolean b = false;

        int[] spieler = new int[anzahlSpieler];

        for (int i = 0; i < anzahlSpieler; i++) {
            spieler[i] = 501;
        }

        while (true) {
            for (int i = 0; i < spieler.length; i++) {
                System.out.println("\nSpieler " + (i + 1) + " ist dran.");
                System.out.println("Übrige Punkte: " + spieler[i] + "\n");
                while (wuerfe < 3) {
                    System.out.println("Geben Sie die Punktzahl Ihres " + (wuerfe + 1) + ". Wurfes ein (0-60)");
                    wurf += input.nextInt();
                    wuerfe += 1;
                }
                wuerfe = 0;

                System.out.println("\nSie haben in dieser Runde " + wurf + " Punkte erzielt");

                spieler[i] -= wurf;

                if (spieler[i] == 0) {
                    b = true;
                    sieger = i + 1;
                    break;
                } else if (spieler[i] < 0) {
                    spieler[i] += wurf;
                }
                System.out.println("Verbleibende Punkte Spieler " + (i + 1) + ": " + spieler[i]);
                wurf = 0;
            }
            if (b) {
                break;
            }
        }
        System.out.println("\nSpieler " + sieger + " hat gewonnen.");
    }
}
