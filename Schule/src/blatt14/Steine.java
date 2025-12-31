package blatt14;

import blatt13.Zufall;
import schisch_visualizer.SchischVisualizer;

public class Steine {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] tetris = MultiArrays.createEmpty2DCharArray(10, 40);

    static char[][] I = new char[][] {{'6','6','6','6'}};
    static char[][] O = new char[][] {{'5','5'}, {'5','5'}};
    static char[][] T = new char[][] {{' ', 'C'}, {'C', 'C'}, {' ', 'C'}};
    static char[][] S = new char[][] {{' ', 'B'}, {'B', 'B'}, {'B', ' '}};
    static char[][] Z = new char[][] {{'4', ' '}, {'4', '4'}, {' ', '4'}};
    static char[][] J = new char[][] {{'2', '2'}, {' ', '2'}, {' ', '2'}};
    static char[][] L = new char[][] {{' ', 'A'}, {' ', 'A'}, {'A', 'A'}};

    static char[][][] tetrominos = {I, O, T, S, Z, J, L};

    public static boolean istPlatz(char[][] t, int r, int x, int y) {
        char[][] tetromino = drehe2DcharArray(MultiArrays.copy2DcharArray(t), r);
        for (int i = 0; i < tetromino.length; i++) {
            for (int j = 0; j < tetromino[i].length; j++) {
                if ((x + i >= tetris.length || y + j >= tetris[0].length) || (tetromino[i][j] != ' ' && tetris[x+i][y+j] != ' ')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean keinPlatz(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                return false;
            }
        }
        return true;
    }

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

    public static void zeichneTetromino(char[][] t, int r, int x, int y) {
        char[][] tetromino = drehe2DcharArray(MultiArrays.copy2DcharArray(t), r);
        for (int i = 0; i < tetromino.length; i++) {
            for (int j = 0; j < tetromino[0].length; j++) {
                if (tetromino[i][j] != ' ') {
                    tetris[i + x][j + y] = tetromino[i][j];
                }
            }
        }
    }

    public static void platzmachen(char[][] t, int x, int y) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (tetris[x+i][y+j] == t[i][j] && tetris[x+i][y+j] != ' ') {
                    tetris[x+i][y+j] = ' ';
                }
            }
        }
    }

    public static void stein() {
        int r = Zufall.zufallGanz(3);
        boolean[] X = new boolean[] {true, true, true, true, true, true, true, true, true, true};
        char[][] tetromino = drehe2DcharArray(MultiArrays.copy2DcharArray(tetrominos[Zufall.zufallGanz(6)]), r);
        int x = Zufall.zufallGanz(9);
        while (!istPlatz(tetromino, r, x, 0)) {
            X[x] = false;
            if (keinPlatz(X)) {
                break;
            }
            x = Zufall.zufallGanz(9);
            while (!X[x]) {
                x = Zufall.zufallGanz(9);
            }
        }
        if (!keinPlatz(X)) {
            fallen(tetromino, x);
        }
    }

    public static void fallen(char[][] tetromino, int x) {
        int y = 1;
        zeichneTetromino(tetromino, 0, x, 0);
        sv.step(tetris);
        platzmachen(tetromino, x, 0);
        while (istPlatz(tetromino, 0, x, y)) {
            zeichneTetromino(tetromino, 0, x, y);
            sv.step(tetris);
            platzmachen(tetromino, x, y);
            y++;
        }
        zeichneTetromino(tetromino, 0, x, y - 1);
        sv.step(tetris);
        stein();
    }

    public static void tetris() {

    }

    public static void gameOver() {

    }

    public static void main(String[] args) {
        stein();
        sv.start();
    }
}
