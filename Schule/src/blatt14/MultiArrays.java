package blatt14;

import blatt13.Zufall;

public class MultiArrays {

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    public static void print2DArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    public static void print2DArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    public static int[][] createRandom2DIntArray(int a, int b, int p, int q) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = Zufall.zufallGanz(p, q);
            }
        }
        return arr;
    }

    public static double[][] createRandom2DDoubleArray(int a, int b) {
        double[][] arr = new double[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = Math.random();
            }
        }
        return arr;
    }

    public static int[][] createCountingArray(int a, int b) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = i * b + j;
            }
        }
        return arr;
    }

    public static char[][] createEmpty2DCharArray(int a, int b) {
        char[][] arr = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    public static boolean istIdentisch(char[][] arr1, char[][] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) {
                return false;
            }
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void shiftRows(char[][] arr, int row, int offset) {

        for (int i = 0; i < offset; i++) {
            char end = arr[row][arr[row].length - 1];
            for (int j = arr[row].length - 1; j > 0; j--) {
                arr[row][j] = arr[row][j - 1];
            }
            arr[row][0] = end;
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}, {'1', '2', '3', '4', '5', '6'}};
        shiftRows(arr,2,5);
        print2DArray(arr);
    }
}
