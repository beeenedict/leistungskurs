package blatt07;

public class ArbeitMitArrays {

    /**
     * Gibt den angegebenen Array in der Klammerschreibweise aus.
     * @param array Datentyp int[]
     */

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    /**
     * Gibt den angegebenen Array in der Klammerschreibweise aus.
     * @param array Datentyp double[]
     */

    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    /**
     * Gibt den angegebenen Array in der Klammerschreibweise aus.
     * @param array Datentyp boolean[]
     */

    public static void printArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    /**
     * Gibt den angegebenen Array in der Klammerschreibweise aus.
     * @param array Datentyp char[]
     */

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    /**
     * Gibt den angegebenen Array in der Klammerschreibweise aus.
     * @param array Datentyp String[]
     */

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    /**
     * Sind die Werte in aufsteigender Reihenfolge angeordnet
     * @param array Array
     * @return Ja / Nein -> true / false
     */

    public static boolean istSortiert(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Klont den angegebenen int[] Array
     * @param array
     * @return int[] clone
     */

    public static int[] cloneIntArr(int[] array) {
        int[] clone = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            clone[i] = array[i];
        }
        return clone;
    }

    /**
     * Addieren aller Werte zweier beliebiger int Arrays an gleicher Stelle
     * @param array1 int[] Array 1
     * @param array2 int[] Array 2
     * @return int[] sumArray (= array1 + array2), Summe der Werte beider Arrays an gleicher Stelle
     */

    public static int[] addieren(int[] array1, int[] array2) {
        int l = array1.length;
        int k = array2.length;
        int[] lanArray = cloneIntArr(array1);
        if (array1.length < array2.length) {
            l = array2.length;
            k = array1.length;
            lanArray = cloneIntArr(array2);
        }
        int[] sumArray = new int[l];
        for (int i = 0; i < l; i++) {
            if (i < k) {
                sumArray[i] = array1[i] + array2[i];
            }
            else {
                sumArray[i] = lanArray[i];
            }
        }
        return sumArray;
    }

    /**
     * Alle Werte im Array werden um eine Position nach links verschoben, das Erste ganz nach hinten gesetzt.
     * @param array int[] Array
     */

    public static void shiftLeft(int[] array) {
        int anf = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = anf;
    }

    /**
     * Alle Werte im Array werden um eine Position nach rechts verschoben, das Letzte ganz nach vorne gesetzt.
     * @param array int[] Array
     */

    public static void shiftRight(int[] array) {
        int end = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = end;
    }

    /**
     * Alle Werte im Array werden um eine Position nach links verschoben, der erste Wert wird 0.
     * @param array int[] Array
     */

    public static void shiftLeftAbsolute(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }

    /**
     * Alle Werte im Array werden um eine Position nach rechts verschoben, der letzte Wert wird 0.
     * @param array int[] Array
     */

    public static void shiftRightAbsolute(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = 0;
    }
}
