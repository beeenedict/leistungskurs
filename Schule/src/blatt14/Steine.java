package blatt14;

import blatt13.Zufall;
import schisch_visualizer.SchischVisualizer;

public class Steine {

    static int rounds = 1;
    static int t = 0;

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

    /**
     * Prüft, ob an gegebener Position Platz für einen gegebenen Stein mit gegebener Rotation P
     * @param t char[][]
     * @param r int
     * @param x int
     * @param y int
     * @return boolean -> ist Platz?
     */

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

    /**
     * Dreht einen 2D-char-Array eine gegebene Anzahl oft um 90°
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
     * Zeichnet ein gegebenes Tetromino mit gegebener Rotation an gegebener Position
     * @param t char[][]
     * @param r int
     * @param x int
     * @param y int
     */

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

    /**
     * Leert den gegebenen Stein aus einer gegebenen Position
     * @param t char[][]
     * @param x int
     * @param y int
     */

    public static void platzmachen(char[][] t, int x, int y) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (tetris[x+i][y+j] == t[i][j] && tetris[x+i][y+j] != ' ') {
                    tetris[x+i][y+j] = ' ';
                }
            }
        }
    }

    /**
     * Erstellt einen zufälligen Stein und führt fallen() aus, solange die Runde läuft
     */

    public static void stein() {
        int r = Zufall.zufallGanz(3);
        char[][] tetromino = drehe2DcharArray(MultiArrays.copy2DcharArray(tetrominos[Zufall.zufallGanz(6)]), r);
        //char[][] tetromino = drehe2DcharArray(MultiArrays.copy2DcharArray(tetrominos[0]), 0);
        int x = Zufall.zufallGanz(10 - tetromino.length);
        //while (x%2 != 0) {
        //    x = Zufall.zufallGanz(10 - tetromino.length);
        //}
        if (istPlatz(tetromino, 0, x, 0)) {
            fallen(tetromino, x);
        }
        else {
            gameOver();
        }
    }

    /**
     * Simuliert den fallenden Stein bis eine Kollision bevorsteht
     * @param tetromino
     * @param x
     */

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
        tetris();
        if (rounds > 0) {
            stein();
        }
    }

    /**
     * Überprüft das Spielfeld auf gefüllte Zeilen und führt bei Bedarf einen clear() durch
     */

    public static void tetris() {
        boolean clear;
        for (int i = 0; i < tetris[0].length; i++) {
            clear = true;
            for (int j = 0; j < tetris.length; j++) {
                if (tetris[j][i] == ' ') {
                    clear = false;
                }
            }
            if (clear) {
                t++;
                clear(i);
            }
        }
    }

    /**
     * Leert die Zeile y und verschiebt die darüberliegenden um 1 nach unten.
     * @param y int
     */

    public static void clear(int y) {
        char[][] temp = MultiArrays.copy2DcharArrayRows(tetris, y);
        for (int i = 0; i < tetris.length; i++) {
            tetris[i][0] = ' ';
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                tetris[i][j + 1] = temp[i][j];
            }
        }
        sv.step(tetris);
    }

    /**
     * Beendet die verlorene Runde und startet bei Bedarf die nächste Runde der Simulation
     */

    public static void gameOver() {
        char[] f = new char[]{'4', '4', 'F', '1', '1', '1'};
        for (int i = 0; i < tetris[0].length; i++) {
            for (int j = 0; j < tetris.length; j++) {
                tetris[j][i] = f[Zufall.zufallGanz(5)];
            }
            sv.step(tetris);
        }
        tetris = MultiArrays.createEmpty2DCharArray(10, 40);
        sv.step(tetris);
        rounds--;
        System.out.println(t);
        if (rounds > 0) {
            stein();
        }
        else {
            sv.start();
        }
    }

    public static void main(String[] args) {
        stein();
    }
}
