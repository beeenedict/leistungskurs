package blatt19;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import blatt16.Stroeme;
import schisch_visualizer.SchischVisualizer;

public class Tiefensuche {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] labyrinth;

    public static void initLabyrinth(int n) {
        labyrinth = leseLabyrinth(n);
        sv.step(labyrinth);
    }

    public static int getX() {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j] == '9') {
                    return i;
                }
            }
        }
        return 0;
    }

    public static int getY() {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j] == '9') {
                    return j;
                }
            }
        }
        return 0;
    }

    public static char[][] leseLabyrinth(int n) {
        if (n < 10) {
            return Stroeme.readCharArray("laby0" + n + ".txt");
        }
        else {
            return Stroeme.readCharArray("laby" + n + ".txt");
        }
    }

    public static int tiefensuche(int x, int y) {
        char[][] labyAlt = MultiArrays.copy2DcharArray(labyrinth);

        if (labyAlt[x+1][y] == '0') {
            labyrinth[x+1][y] = 'P';
        } if (labyAlt[x-1][y] == '0') {
            labyrinth[x-1][y] = 'P';
        } if (labyAlt[x][y+1] == '0') {
            labyrinth[x][y+1] = 'P';
        } if (labyAlt[x][y-1] == '0') {
            labyrinth[x][y-1] = 'P';
        }
        labyrinth[x][y] = '4';

        labyAlt = MultiArrays.copy2DcharArray(labyrinth);

        for (int i = 1; i < labyrinth.length - 1; i++) {
            for (int j = 1; j < labyrinth[i].length - 1; j++) {
                if (labyAlt[i][j] == 'P') {
                    if (labyrinth[i+1][j] == '7' || labyrinth[i-1][j] == '7' || labyrinth[i][j+1] == '7' || labyrinth[i][j-1] == '7') {
                        return 0;
                    }
                    return tiefensuche(i, j);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        initLabyrinth(5);
        tiefensuche(getX(), getY());
        sv.start();
    }
}
