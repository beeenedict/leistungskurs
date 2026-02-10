package blatt15;

import blatt14.MultiArrays;
import schisch_visualizer.SchischVisualizer;

public class Spiegel {

    static char[][] spiegel = MultiArrays.createEmpty2DCharArray(42,42);
    static final char SPIEGEL1 = '/';
    static final char SPIEGEL2 = '\\';
    static final char ZIEL = 'O';

    static SchischVisualizer sv = new SchischVisualizer();

    public static void zufallSpiegel(double c) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[0].length - 1; j++) {
                if (Math.random() < c) {
                    if (Math.random() > 0.5) {
                        spiegel[i][j] = SPIEGEL1;
                    }
                    else {
                        spiegel[i][j] = SPIEGEL2;
                    }
                }
            }
        }
        sv.step(spiegel);
    }

    public static void zufallSpiegelSchwer(double c) {

    }

    public static void main(String[] args) {
        zufallSpiegel(0.2);
        sv.start();
    }
}
