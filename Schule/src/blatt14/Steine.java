package blatt14;

import schisch_visualizer.SchischVisualizer;

public class Steine {

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
                if ((x + i >= tetris.length || y + j >= tetris[0].length) || tetromino[i][j] != ' ' && tetris[x+i][y+j] != ' ') {
                    return false;
                }
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
                tetris[i + x][j + y] = tetromino[i][j];
            }
        }
    }

    public static void tetrisRandom() {

    }

    public static void gameOver() {

    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        if(istPlatz(I, 0, 1, 38)) {
            zeichneTetromino(I, 0, 1, 5);
        }
        else {
            System.out.println("Yay");
        }
        sv.step(tetris);
        sv.start();
    }
}
