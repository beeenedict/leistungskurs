package blatt02;

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
        //TODO: Einschränken der Anzahlen auf nichtnegative Zahlen

        double normaleSDPre = 5.0;
        double miniSDPre = 8.0;
        double microSDPre = 12.0;
        double preisGesamt = normaleSDAnz * normaleSDPre + miniSDAnz * miniSDPre + microSDAnz * microSDPre;

        System.out.println("Der Preis für...");
        System.out.println(normaleSDAnz + " normale SD-Karten");
        System.out.println(miniSDAnz + " MiniSD-Karten");
        System.out.println(microSDAnz + " MicroSD-Karten");
        System.out.printf("...lautet %.2f €", preisGesamt);
    }
}
