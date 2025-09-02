package blatt03;

import java.util.Scanner;

public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Wieviele normale SD-Karten möchten Sie kaufen?");
        int normaleSDAnz = input.nextInt();
        System.out.println("Wieviele MiniSD-Karten möchten Sie kaufen?");
        int miniSDAnz = input.nextInt();
        System.out.println("Wieviele MicroSD-Karten möchten Sie kaufen?");
        int microSDAnz = input.nextInt();

        // a)
        if (normaleSDAnz < 0 || miniSDAnz < 0 || microSDAnz < 0) {
            if (normaleSDAnz < 0) {
                System.out.println("Bitte geben sie eine nichtnegative Anzahl an normalen SD-Karten an.");
            }
            if (miniSDAnz < 0) {
                System.out.println("Bitte geben Sie eine nichtnegative Anzahl an MiniSD-Karten an.");
            }
            if (microSDAnz < 0) {
                System.out.println("Bitte geben Sie eine nichtnegative Anzahl an MicroSD-Karten an.");
            }
            System.exit(0);
        }

        // b)
        if (normaleSDAnz > 50 || miniSDAnz > 50 || microSDAnz > 50) {
            if (normaleSDAnz > 50) {
                System.out.println("Die maximale Bestellmenge beträgt 50 normale SD-Karten und wurde entsprechend angepasst.");
                normaleSDAnz = 50;
            }
            if (miniSDAnz > 50) {
                System.out.println("Die maximale Bestellmenge beträgt 50 MiniSD-Karten und wurde entsprechend angepasst.");
                miniSDAnz = 50;
            }
            if (microSDAnz > 50) {
                System.out.println("Die maximale Bestellmenge beträgt 50 MicroSD-Karten und wurde entsprechend angepasst.");
                microSDAnz = 50;
            }
            System.out.println(" ");
        }

        double normaleSDPre = 5.0;
        double miniSDPre = 8.0;
        double microSDPre = 12.0;
        double preisGesamt = normaleSDAnz * normaleSDPre + miniSDAnz * miniSDPre + microSDAnz * microSDPre;

        // c)
        if (normaleSDAnz + miniSDAnz + microSDAnz > 15) {
            System.out.println("Da Sie einen Einkauf von mehr als 15 Produkten tätigen, erhalten Sie einen Mengenrabat von 15% auf alle Artikel.");
            System.out.println("Alter Preis: " + preisGesamt + " €");
            preisGesamt *= 0.85;
            System.out.println("Neuer Preis: " + preisGesamt + " €\n");
        }

        System.out.println("Der Preis für...");
        System.out.println(normaleSDAnz + " normale SD-Karten");
        System.out.println(miniSDAnz + " MiniSD-Karten");
        System.out.println(microSDAnz + " MicroSD-Karten");
        System.out.printf("...lautet %.2f €", preisGesamt);
    }
}