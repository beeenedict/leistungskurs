package blatt19;

import blatt16.Stroeme;
import schisch_visualizer.SchischVisualizer;

public class Tiefensuche {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] labyrinth;

    public static void initLabyrinth(int n) {
        labyrinth = leseLabyrinth(n);
    }

    public static char[][] leseLabyrinth(int n) {
        if (n < 10) {
            return Stroeme.readCharArray("laby0" + n + ".txt");
        }
        else {
            return Stroeme.readCharArray("laby" + n + ".txt");
        }
    }

    public static void tiefensuche(int x, int y) {

    }

    public static boolean[] erhalteWege(int x, int y) {
        boolean[] wege =  new boolean[4];

        if (x > 0 && - 1 == '0') {

        }
        if (y > 0) {}

        return wege;
    }

    public static void main(String[] args) {}
}
