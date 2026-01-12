package blatt13;

import java.util.Arrays;

public class Zufall {

    /**
     * Gibt einen zufälligen Wert zwischen 0 und b aus
     * @param b int
     * @return Zufallswert
     */

    public static double zufall(int b) {
        return Math.random() * b;
    }

    /**
     * Gibt eine zufällige Ganzzahl zwischen 0 und b aus
     * @param b int
     * @return Zufallswert
     */

    public static int zufallGanz(int b) {
        return (int) (Math.random() * (b + 1));
    }

    /**
     * Gibt einen zufälligen Wert zwischen a und b aus
     * @param a int
     * @param b int
     * @return Zufallswert
     */

    public static double zufall(int a, int b) {
        return (Math.random() * Math.abs(b-a)) + a;
    }

    /**
     * Gibt eine zufällige Ganzzahl zwischen a und b aus
     * @param a int
     * @param b int
     * @return Zufallswert
     */

    public static int zufallGanz(int a, int b) {
        return (int) Math.round(Math.random() * Math.abs(b-a) + a);
    }

    /**
     * Gibt einen Array der Länge l zufälliger Ganzzahlen zwischen a und b aus
     * @param a int
     * @param b int
     * @param l int
     * @return int[] an Zufallszahlen
     */

    public static int[] zufallArray(int a, int b, int l) {
        int[] arr = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = zufallGanz(a, b);
        }
        return arr;
    }
}
