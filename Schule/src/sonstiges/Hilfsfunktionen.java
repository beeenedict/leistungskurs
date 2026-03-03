package sonstiges;

import blatt14.MultiArrays;

public class Hilfsfunktionen {

    /**
     * Zeichnet einen gegebenen 2D-CharArray an gegebener Position auf ein Feld.
     * @param bild char[][]
     * @param x int
     * @param y int
     */

    public static void zeichnen(char[][] feld, char[][] bild, int x, int y) {
        for (int i = 0; i < bild.length; i++) {
            for (int j = 0; j < bild[0].length; j++) {
                if (bild[i][j] != ' ') {
                    feld[i + x][j + y] = bild[i][j];
                }
            }
        }
    }

    /**
     * Dreht einen 2D-char-Array eine gegebene Anzahl oft um 90° nach rechts.
     * @param arr char[][]
     * @param r int
     * @return char[][] gedreht
     */

    public static char[][] drehe2DcharArray(char[][] arr, int r) {
        if (r%4 == 0) {
            return arr;
        }
        while (r > 4) {
            r -= 4;
        }
        char[][] charr = new char[0][0];
        for (int k = 0; k < r; k++) {
            charr = new char[arr[0].length][arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    charr[charr.length - 1 - j][i] = arr[i][j];
                }
            }
            arr = charr;
        }
        return charr;
    }

    /**
     * Prüft, ob an gegebener Position Platz (leere Felder an Stelle der nicht-leeren Felder d. Arrays) für einen gegebenes Array ist
     * @param feld char[][]
     * @param arr char[][]
     * @param x int
     * @param y int
     * @return boolean -> ist Platz?
     */

    public static boolean istPlatz(char[][] feld, char[][] arr, int x, int y) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((x + i >= feld.length || y + j >= feld[0].length) || (arr[i][j] != ' ' && arr[x+i][y+j] != ' ')) {
                    return false;
                }
            }
        }
        return true;
    }
}
