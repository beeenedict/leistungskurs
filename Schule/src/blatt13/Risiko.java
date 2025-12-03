package blatt13;

import blatt12.InsertionSort;
import blatt12.SelectionSort;

public class Risiko {

    public static double erfolgsWahrscheinlichkeit(int figurenAtk, int figurenDef) {
        int[] wuerfelAtk = new int[3];
        int[] wuerfelDef = new int[2];

        for (int i = 0; i < wuerfelAtk.length; i++) {
            wuerfelAtk[i] = PenAndPaper.wuerfel(1, 6);
        }
        for (int i = 0; i < wuerfelDef.length; i++) {
            wuerfelDef[i] = PenAndPaper.wuerfel(1, 6);
        }

        InsertionSort.insertionSortBetter(wuerfelAtk);
        InsertionSort.insertionSortBetter(wuerfelDef);

    }
}
