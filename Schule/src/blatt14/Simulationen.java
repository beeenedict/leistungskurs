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

    public static char getNorden(char[][] arr, int x, int y, boolean rand) {
        y--;
        if (y < 0 && rand) {
            y = arr.length - 1;
        }
        else if (y < 0) {
            return '-';
        }
        return arr[x][y];
    }

    public static char getSueden(char[][] arr, int x, int y, boolean rand) {
        y++;
        if (y == arr.length && rand) {
            y = 0;
        }
        else if (y == arr.length) {
            return '-';
        }
        return arr[x][y];
    }

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

    public static char getOsten(char[][] arr, int x, int y, boolean rand) {
        x++;
        if (x == arr.length && rand) {
            x = 0;
        }
        else if (x == arr.length) {
            return '-';
        }
        return arr[x][y];
    }

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
            y = arr.length - 1;
        }
        return arr[x][y];
    }

    public static char getNordOst(char[][] arr, int x, int y, boolean rand) {
        y--;
        x++;
        if ((x == arr.length || y < 0) && !rand) {
            return '-';
        }
        if (rand && x == arr.length) {
            x = 0;
        }
        if (rand && y < 0) {
            y = arr.length - 1;
        }
        return arr[x][y];
    }

    public static char getSuedOst(char[][] arr, int x, int y, boolean rand) {
        y++;
        x++;
        if ((x == arr.length || y == arr.length) && !rand) {
            return '-';
        }
        if (rand && x == arr.length) {
            x = 0;
        }
        if (rand && y == arr.length) {
            y = 0;
        }
        return arr[x][y];
    }

    public static char getSuedWest(char[][] arr, int x, int y, boolean rand) {
        y++;
        x--;
        if ((x < 0 || y == arr.length) && !rand) {
            return '-';
        }
        if (rand && x < 0) {
            x = arr.length - 1;
        }
        if (rand && y == arr.length) {
            y = 0;
        }
        return arr[x][y];
    }

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
