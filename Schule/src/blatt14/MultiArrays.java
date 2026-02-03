package blatt14;

import blatt13.Zufall;

public class MultiArrays {

    /**
     * Ausgabe eines zweidimensionalen Int-Arrays
     * @param arr int[][]
     */

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    /**
     * Ausgabe eines zweidimensionalen Double-Arrays
     * @param arr double[][]
     */

    public static void print2DArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    /**
     * Ausgabe eines zweidimensionalen Char-Arrays
     * @param arr char[][]
     */

    public static void print2DArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            blatt07.ArbeitMitArrays.printArray(arr[i]);
        }
    }

    /**
     * Erstellt einen zweidimensinalen Int-Array der Größe a x b und füllt ihn mit zufälligen Ganzzahlen zwischen p und q
     * @param a int Breite
     * @param b int Höhe
     * @param p int untere Grenze
     * @param q int obere Grenze
     * @return 2D-Array
     */

    public static int[][] createRandom2DIntArray(int a, int b, int p, int q) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = Zufall.zufallGanz(p, q);
            }
        }
        return arr;
    }

    /**
     * Erstellt einen zweidimensinalen Double-Array der Größe a x b und füllt ihn mit zufälligen Gleitkommazahlen zwischen 0 und 1
     * @param a int Breite
     * @param b int Höhe
     * @return 2D-Array
     */

    public static double[][] createRandom2DDoubleArray(int a, int b) {
        double[][] arr = new double[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = Math.random();
            }
        }
        return arr;
    }

    /**
     * Erstellt einen zweidimensinalen Int-Array der Größe a x b und füllt ihn der Reihenfolge nach mit Ganzzahlen
     * @param a int Breite
     * @param b int Höhe
     * @return 2D-Array
     */

    public static int[][] createCountingArray(int a, int b) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = i * b + j;
            }
        }
        return arr;
    }

    /**
     * Erstellt einen zweidimensinalen Char-Array der Größe a x b und füllt ihn mit Lehrzeichen
     * @param a int Breite
     * @param b int Höhe
     * @return 2D-Array
     */

    public static char[][] createEmpty2DCharArray(int a, int b) {
        char[][] arr = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }

    /**
     * Überprüft ob zwei zweidimensionale Char-Arrays einander identisch sind.
     * @param arr1 char[][]
     * @param arr2 char[][]
     * @return boolean
     */

    public static boolean istIdentisch(char[][] arr1, char[][] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) {
                return false;
            }
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Überprüft ob zwei zweidimensionale Char-Arrays einander identisch sind.
     * @param arr1 char[][]
     * @param arr2 char[][]
     * @return boolean
     */

    public static boolean istIdentisch3D(char[][][] arr1, char[][][] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (istIdentisch(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Kopiert einen gegebenen zweidimensionalen char-Array
     * @param arr char[][]
     * @return char[][]
     */

    public static char[][] copy2DcharArray(char[][] arr) {
        char[][] charr = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                charr[i][j] = arr[i][j];
            }
        }
        return charr;
    }

    /**
     * Kopiert einen gegebenen dreidimensionalen char-Array
     * @param arr char[][]
     * @return char[][]
     */

    public static char[][][] copy3DcharArray(char[][][] arr) {
        char[][][] charr = new char[arr.length][arr[0].length][arr[0][0].length];
        for (int i = 0; i < arr.length; i++) {
            charr[i] = copy2DcharArray(arr[i]);
        }
        return charr;
    }

    /**
     * Kopiert von einem gegebenen zweidimensionalen char-Array die ersten y Spalten
     * @param arr char[][]
     * @param y int
     * @return char[][]
     */

    public static char[][] copy2DcharArrayRows(char[][] arr, int y) {
        char[][] charr = new char[arr.length][y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < y; j++) {
                charr[i][j] = arr[i][j];
            }
        }
        return charr;
    }

    /**
     * Verschiebt alle Werte einer gegebenen Reihe eines 2D-Arrays um eine gegebene Anzahl nach rechts.
     * @param arr char[][]
     * @param row int
     * @param offset int
     */

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
