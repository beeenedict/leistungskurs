package blatt14;

import blatt13.Zufall;

public class Simulationen {

    /**
     * Füllt alle Stellen eines gegebenen 2D-Arrays zu p% mit dem char c
     * @param arr char[][]
     * @param c char
     * @param p double
     */

    public static void fuellen(char[][] arr, char c, double p) {
        boolean chance;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                chance = Zufall.zufall(1) <= p;
                if (chance && arr[i][j] == ' ') {
                    arr[i][j] = c;
                }
            }
        }
    }

    /**
     * Füllt alle mit char n belegten Stellen eines gegebenen 2D-Arrays zu p% mit dem char c
     * @param arr char[][]
     * @param c char
     * @param n char
     * @param p double
     */

    public static void fuellen(char[][] arr, char c, char n, double p) {
        boolean chance;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                chance = Zufall.zufall(1) <= p;
                if (chance && arr[i][j] == n) {
                    arr[i][j] = c;
                }
            }
        }
    }

    /**
     * Platziert den char c an einer zufälligen Stelle im gegebenen 2D-Array
     * @param arr char[][]
     * @param c char
     * @param dopplung boolean
     */

    public static void platzieren(char[][] arr, char c, boolean dopplung) {
        int i;
        int j;

        while (true) {
            i = Zufall.zufallGanz(arr.length-1);
            j = Zufall.zufallGanz(arr[i].length-1);

            if(arr[i][j] != c) {
                arr[i][j] = c;
                break;
            }
        }
    }

    /**
     * Gibt den Wert zurück, den die Stelle nördlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Norden
     */

    public static char getNorden(char[][] arr, int x, int y, boolean rand) {
        y--;
        if (y < 0 && rand) {
            y = arr[x].length - 1;
        }
        else if (y < 0) {
            return '-';
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle südlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Süden
     */

    public static char getSueden(char[][] arr, int x, int y, boolean rand) {
        y++;
        if (y >= arr[x].length && rand) {
            y = 0;
        }
        else if (y >= arr[x].length) {
            return '-';
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle westlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Westen
     */

    public static char getWesten(char[][] arr, int x, int y, boolean rand) {
        x--;
        if (x < 0 && rand) {
            x = arr.length - 1;
        }
        else if (x < 0) {
            return '-';
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle östlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Osten
     */

    public static char getOsten(char[][] arr, int x, int y, boolean rand) {
        x++;
        if (x >= arr.length && rand) {
            x = 0;
        }
        else if (x >= arr.length) {
            return '-';
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle nordwestlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Nordwesten
     */

    public static char getNordWest(char[][] arr, int x, int y, boolean rand) {
        y--;
        x--;
        if ((x < 0 || y < 0) && !rand) {
            return '-';
        }
        if (rand && x < 0) {
            x = arr.length - 1;
        }
        if (rand && y < 0) {
            y = arr[x].length - 1;
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle nordöstlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Nordosten
     */

    public static char getNordOst(char[][] arr, int x, int y, boolean rand) {
        y--;
        x++;
        if ((x >= arr.length || y < 0) && !rand) {
            return '-';
        }
        if (rand && x >= arr.length) {
            x = 0;
        }
        if (rand && y < 0) {
            y = arr[x].length - 1;
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle südöstlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Südosten
     */

    public static char getSuedOst(char[][] arr, int x, int y, boolean rand) {
        y++;
        x++;
        if ((x >= arr.length || y >= arr[x].length) && !rand) {
            System.out.println("o");
            return '-';
        }
        if (rand && x >= arr.length) {
            x = 0;
        }
        if (rand && y >= arr[x].length) {
            y = 0;
        }
        return arr[x][y];
    }

    /**
     * Gibt den Wert zurück, den die Stelle südwestlich vom gegebenen Feld (x, y) in einem gegebenen 2D-Array enthält
     * @param arr char[][]
     * @param x int
     * @param y int
     * @param rand boolean
     * @return char Wert Südwesten
     */

    public static char getSuedWest(char[][] arr, int x, int y, boolean rand) {
        y++;
        x--;
        if ((x < 0 || y >= arr[x].length) && !rand) {
            System.out.println("w");
            return '-';
        }
        if (rand && x < 0) {
            x = arr.length - 1;
        }
        if (rand && y >= arr[x].length) {
            y = 0;
        }
        return arr[x][y];
    }

    /**
     * Gibt die Anzahl der der gegebenen Position umliegenden 4 Felder zurück, dessen Wert dem char n entspricht
     * @param arr char[][]
     * @param n char
     * @param x int
     * @param y int
     * @param rand boolean
     * @return int anz
     */

    public static int zaehlenVier(char[][] arr, char n, int x, int y, boolean rand) {
        int z = 0;
        if (getNorden(arr, x, y, rand) == n) {
            z++;
        }
        if (getSueden(arr, x, y, rand) == n) {
            z++;
        }
        if (getWesten(arr, x, y, rand) == n) {
            z++;
        }
        if (getOsten(arr, x, y, rand) == n) {
            z++;
        }
        return z;
    }

    /**
     * Gibt die Anzahl der der gegebenen Position umliegenden 8 Felder zurück, dessen Wert dem char n entspricht
     * @param arr char[][]
     * @param n char
     * @param x int
     * @param y int
     * @param rand boolean
     * @return int anz
     */

    public static int zaehlenAcht(char[][] arr, char n, int x, int y, boolean rand) {
        int z = zaehlenVier(arr, n, x, y, rand);
        if (getNordWest(arr, x, y, rand) == n) {
            z++;
        }
        if (getNordOst(arr, x, y, rand) == n) {
            z++;
        }
        if (getSuedWest(arr, x, y, rand) == n) {
            z++;
        }
        if (getSuedOst(arr, x, y, rand) == n) {
            z++;
        }
        return z;
    }
}
