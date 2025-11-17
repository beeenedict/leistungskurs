package blatt12;

public class InsertionSort {

    /**
     * Sortiert einen gegebenen int-Array, indem die "richtige" Stelle eines Elements berechnet wird.
     * @param arr int[]
     * @return int[] sortiert
     */

    public static int[] insertionSort(int[] arr) {
        int[] arrSortiert = new int[arr.length];
        int element;
        int count;

        for (int i = 0; i < arr.length; i++) {
            element = arr[i];
            count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < element) {
                    count++;
                }
            }
            arrSortiert[count] = element;
        }

        return arrSortiert;
    }

    /**
     * Sortiert einen gegebenen int-Array, indem die "richtige" Stelle eines Elements berechnet wird, und der Rest des Arrays verschoben wird, um diesem platzzumachen.
     * @param arr int[]
     */

    public static void insertionSortBetter(int[] arr) {
        int n = arr.length;
        int wert;
        int j;

        for (int i = 1; i < n; i++) {
            wert = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > wert) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = wert;
        }
    }
}
