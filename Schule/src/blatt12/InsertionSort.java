package blatt12;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{110,10,1,100,1,7};

        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {
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
