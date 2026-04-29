package blatt19;

import blatt07.ArbeitMitArrays;

public class QuickSort {

    /**
     * Übernimmt alle Stellen des Arrays arr deren Wert kleiner ist als arr[s]
     * @param s int
     * @param arr int Array
     * @return int Array links
     */

    public static int[] trennenLinks(int s, int[] arr) {
        int l = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[s]) {
                l++;
            }
        }

        int[] arrNew = new int[l];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[s]) {
                arrNew[k] = arr[i];
                k++;
            }
        }

        return arrNew;
    }

    /**
     * Übernimmt alle Stellen des Arrays arr deren Wert größer ist als arr[s]
     * @param s int
     * @param arr int Array
     * @return int Array rechts
     */

    public static int[] trennenRechts(int s, int[] arr) {
        int l = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr[s] && s != i) {
                l++;
            }
        }

        int[] arrNew = new int[l];
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr[s] && s != i) {
                arrNew[k] = arr[i];
                k++;
            }
        }

        return arrNew;
    }

    /**
     * Fügt Array links und Array rechts zusammen
     * @param arr1 int Array links
     * @param arr2 int Array rechts
     * @param piv int
     * @return int Array zusammengefügt
     */

    public static int[] zusammenfuegen(int[] arr1, int[] arr2, int piv) {
        int[] arrNew = new int[arr1.length + arr2.length + 1];

        for (int i = 0; i < arr1.length; i++) {
            arrNew[i] = arr1[i];
        }
        arrNew[arr1.length] = piv;
        for (int i = 0; i < arr2.length; i++) {
            arrNew[arr1.length + 1 + i] = arr2[i];
        }

        return arrNew;
    }

    /**
     * Quicksort Algorithmus
     * @param arr int
     * @param pivS int
     * @return int Array sortiert
     */

    public static int[] quickSort(int[] arr, int pivS) {
        if (arr.length > 1) {
            int piv = arr[pivS];
            int[] kUnsortiert = trennenLinks(pivS, arr);
            int[] gUnsortiert = trennenRechts(pivS, arr);
            int[] kSortiert = quickSort(kUnsortiert, pivS);
            int[] gSortiert = quickSort(gUnsortiert, pivS);
            return zusammenfuegen(kSortiert, gSortiert, piv);
        }
        else {
            return arr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 42, 0, 1001000, 1101001, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArbeitMitArrays.printArray(quickSort(arr, 0));
    }
}
