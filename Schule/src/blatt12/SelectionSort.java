package blatt12;

public class SelectionSort {

    /**
     * Sortiert die Elemente eines int-Arrays
     * @param arr int[]
     */

    public static void Selectionsort(int[] arr) {
        int min;

        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            blatt11.BubbleSort.swap(arr, min, i);
        }
    }
}
