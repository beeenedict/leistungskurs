package blatt11;

public class BubbleSort {

    /**
     * Tauscht Element a und b eines gegebenen Arrays
     * @param arr int[]
     * @param a int 1. Stelle
     * @param b int 2. Stelle
     */

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Der Array arr wird von groß nach klein sortiert.
     * @param arr int[]
     */

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(blatt07.ArbeitMitArrays.istSortiert(arr));
    }

    /* d)

        O(n * (n - 1)) => O(n^2)

     */

    /* e)

        Im Best-Case reduziert eine solche Überprüfung tatsächlich den Aufwand, da aber nach jedem Durchlauf ein zusätzlicher Aufwand von n durchgeführt wird,
        lohnt sich die Überprüfung im Average-Case nicht, da beim Worst-Case ein Aufwand von n * 2n entstehen würde.

     */
}
