package blatt14;

import blatt13.Zufall;

public class Simulationen {

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

    public static void platzieren(char[][] arr, char c, boolean dopplung) {
        int i = Zufall.zufallGanz(arr.length-1);
        int j = Zufall.zufallGanz(arr[i].length-1);

        if(arr[i][j] != c) {
            dopplung = false;
        }
        arr[i][j] = c;

        while (dopplung) {
            i = Zufall.zufallGanz(arr.length-1);
            j = Zufall.zufallGanz(arr[i].length-1);

            if(arr[i][j] != c) {
                arr[i][j] = c;
                break;
            }
        }
    }

    public static char getNord(char[][] arr, int x, int y, boolean rand) {
        y--;
        if (y < 0 && rand) {
            y = arr.length;
        }
        else if (y < 0) {
            return '-';
        }
        else {
            return arr[x][y];
        }
        return '-';
    }

    public static char getSued(char[][] arr, int x, int y, boolean rand) {
        y++;
        if (y == arr.length && rand) {
            y = 0;
        }
        else if (y == arr.length) {
            return '-';
        }
        else {
            return arr[x][y];
        }
        return '-';
    }

    public static char getWest(char[][] arr, int x, int y, boolean rand) {
        boolean amRand = x - 1 < 0;
        if (rand && amRand) {
            return arr[arr.length - 1][y];
        }
        else if (amRand) {
            return ' ';
        }
        else {
            return arr[x - 1][y];
        }
    }

    public static char getEast(char[][] arr, int x, int y, boolean rand) {
        boolean amRand = x + 1 == arr.length;
        if (rand && amRand) {
            return arr[0][y];
        }
        else if (amRand) {
            return ' ';
        }
        else {
            return arr[x + 1][y];
        }
    }

    public static char getNordWest(char[][] arr, int x, int y, boolean rand) {
        boolean amRand = y - 1 < 0 || x - 1 < 0;
        if (rand && amRand) {
            return arr[x][arr.length - 1];
        }
        else if (amRand) {
            return ' ';
        }
        else {
            return arr[x][y - 1];
        }
    }

}
