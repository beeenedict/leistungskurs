package blatt17;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import blatt14.Steine;
import schisch_visualizer.SchischVisualizer;
import java.util.Scanner;

public class GameOfLife {

    static SchischVisualizer sv = new SchischVisualizer();
    static char[][] welt;

    static final char[][] BLINKER = new char[][]{
            {'0', '0', '0'}
    };

    public static void initRandom(double c) {
        welt = MultiArrays.createEmpty2DCharArray(100, 100);
        Simulationen.fuellen(welt, '1', 1);
        Simulationen.fuellen(welt, '0', '1', c);
        sv.step(welt);
    }

    public static void leben(int g, boolean r) {
        for (int i = 0; i < g; i++) {
            char[][] vergangenheit = MultiArrays.copy2DcharArray(welt);

            for (int j = 0; j < welt.length; j++) {
                for (int k = 0; k < welt[j].length; k++) {
                    if (vergangenheit[j][k] == '1' && Simulationen.zaehlenAcht(vergangenheit, '0', j, k, r) == 3) {
                        welt[j][k] = '0';
                    }
                    else if (Simulationen.zaehlenAcht(vergangenheit, '0', j, k, r) < 2 || Simulationen.zaehlenAcht(vergangenheit, '0', j, k, r) > 3) {
                        welt[j][k] = '1';
                    }
                }
            }
            sv.step(welt);
        }
    }
}