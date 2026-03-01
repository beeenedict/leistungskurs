package blatt17;

import blatt13.Zufall;
import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class Waldentwicklung {
    static SchischVisualizer sv = new SchischVisualizer();
    static char[][] wald;

    /**
     * Simuliert die Waldentwicklung bei einem Waldbrand auf der Fläche x * y
     * @param schritte int Anz. Generationen
     * @param x int
     * @param y int
     * @param p double Nachwachswahrscheinlichkeit
     * @param q double Brandwahrscheinlichkeit
     */

    public static void waldentwicklung (int schritte, int x, int y, double p, double q) {
        wald = MultiArrays.createEmpty2DCharArray(x, y);
        char[][] waldAlt;
        double baueme;

        for (int i = 0; i < schritte; i++) {
            waldAlt = MultiArrays.copy2DcharArray(wald);
            for (int j = 0; j < wald.length; j++) {
                for (int k = 0; k < wald[j].length; k++) {
                    baueme = Simulationen.zaehlenVier(wald, '1', k, j, false) * 0.02;
                    if (waldAlt[j][k] == ' ' && Math.random() + baueme > 1 - p) {
                        wald[j][k] = '1';
                    }
                    if (waldAlt[j][k] == '1' &&  Math.random() > 1 - q) {
                        wald[j][k] = '4';
                    }
                    if (waldAlt[j][k] == '4') {
                        wald[j][k] = ' ';
                        if (j >= 1 && wald[j - 1][k] == '1') {
                            wald[j - 1][k] = '4';
                        }
                        if (j < wald.length - 2 && wald[j + 1][k] == '1') {
                            wald[j + 1][k] = '4';
                        }
                        if (k >= 1 && wald[j][k - 1] == '1') {
                            wald[j][k - 1] = '4';
                        }
                        if (k < wald[j].length - 2 && wald[j][k+1] == '1') {
                            wald[j][k + 1] = '4';
                        }
                    }
                }
            }
            sv.step(wald);
        }
    }

    public static void main(String[] args) {
        waldentwicklung(1000, 100, 100, 0.002, 0.0001);
        sv.start();
    }

    /*
    Zustandsmenge Q = {leer, ausgewachsen, brennend}
     */
}
