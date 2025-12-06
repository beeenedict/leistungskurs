package blatt13;

import blatt12.InsertionSort;

public class Risiko {
    /**
     * Führt einen Angriffswurf eine gegebene Anzahl oft aus und berechnet die Wahrscheinöichkeiten des Eintretens bestimmter Ausgänge
     * @param anzVersuche int
     */

    public static void angriff(int anzVersuche) {
        int[] wuerfelAtk = new int[3];
        int[] wuerfelDef = new int[2];
        int angreifer = 0;
        int[] faelle = new int[3];

        for (int j = 0; j < anzVersuche; j++) {
            for (int i = 0; i < wuerfelAtk.length; i++) {
                wuerfelAtk[i] = PenAndPaper.wuerfel(1, 6);
            }
            for (int i = 0; i < wuerfelDef.length; i++) {
                wuerfelDef[i] = PenAndPaper.wuerfel(1, 6);
            }
            InsertionSort.insertionSortBetter(wuerfelAtk);
            InsertionSort.insertionSortBetter(wuerfelDef);
            for (int i = wuerfelDef.length - 1; i >= 0; i--) {
                if (wuerfelAtk[i + 1] > wuerfelDef[i]) {
                    angreifer++;
                }
            }
            faelle[angreifer]++;
            angreifer = 0;
        }
        System.out.printf("Verteidiger verliert zwei Figuren: %.2f%%%n", (double) faelle[0] * 100 / anzVersuche);
        System.out.printf("Beide verlieren eine Figur: %.2f%%%n", (double) faelle[1] * 100 / anzVersuche);
        System.out.printf("Angreifer verliert zwei Figuren: %.2f%%%n", (double) faelle[2] * 100 / anzVersuche);
    }

    public static void main(String[] args) {
        angriff(112);
    }
}
