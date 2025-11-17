package blatt12;

public class SelectionSort {

    /**
     * Sortiert die Elemente eines int-Arrays nach dem Max- oder MinSort.
     * @param arr int[]
     * @param max boolean Max- oder MinSort
     */

    public static void Selectionsort(int[] arr, boolean max) {

        if (max) {
            int maxi;

            for (int i = arr.length - 1; i >= 0; i--) {
                maxi = i;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[maxi]) {
                        maxi = j;
                    }
                }
                blatt11.BubbleSort.swap(arr, maxi, i);
            }
        }

        else {
            int min;

            for (int i = 0; i < arr.length; i++) {
                min = i;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] < arr[min]) {
                        min = j;
                    }
                }
                blatt11.BubbleSort.swap(arr, min, i);
            }
        }
    }

    /*
    public static void main(String[] args) {
        int[] arr = new int[] { 100, 2, -245, 4, 5, 6, 7, -8, 9, 10 };
        Selectionsort(arr, true);
        blatt07.ArbeitMitArrays.printArray(arr);
    }
     */
}
