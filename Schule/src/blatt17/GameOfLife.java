package blatt17;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import blatt14.Steine;
import schisch_visualizer.SchischVisualizer;

public class GameOfLife {

    static final char[][] OSZ1 = new char[][]{
            {'0', '0', '0'}
    };
    static final char[][] OSZ2 = new char[][]{
            {'1', '1', '0', '1'},
            {'0', '1', '0', '1'},
            {'1', '0', '1', '0'},
            {'1', '0', '1', '1'},
    };
    static final char[][] OSZ3 = new char[][]{
            {'1', '0', '0', '0'},
            {'0', '0', '0', '1'},
    };
    static final char[][] OSZ4 = new char[][]{
            {'0', '0', '1', '1'},
            {'0', '1', '1', '1'},
            {'1', '1', '1', '0'},
            {'1', '1', '0', '0'},
    };
    static final char[][] OSZ5 = new char[][]{
            {'0', '0', '1', '1', '1'},
            {'0', '1', '1', '1', '1'},
            {'1', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'1', '1', '1', '0', '0'},
    };
    static final char[][] OSZ6 = new char[][]{
            {'1', '1', '0', '1', '1'},
            {'1', '0', '0', '0', '1'},
            {'0', '0', '0', '0', '0'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'0', '0', '0', '0', '0'},
            {'1', '0', '0', '0', '1'},
            {'1', '1', '0', '1', '1'},
    };
    static final char[][] OSZ7 = new char[][]{
            {'1', '1', '0', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'0', '0', '1', '0', '1'},
            {'0', '1', '0', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'0', '1', '0', '1', '1'},
            {'0', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '0', '1'},
    };
    static final char[][] OSZ8 = new char[][]{
            {'1', '0', '1', '1', '0', '1'},
            {'0', '1', '0', '0', '1', '0'},
            {'1', '0', '1', '1', '0', '1'},
            {'1', '0', '1', '1', '0', '1'},
            {'0', '1', '0', '0', '1', '0'},
            {'1', '0', '1', '1', '0', '1'},
    };
    static final char[][][] OSZILLIEREND = new char[][][]{
            OSZ1, OSZ2, OSZ3, OSZ4, OSZ5, OSZ6, OSZ7, OSZ8
    };

    static final char[][] RSF1 = new char[][]{
            {'1', '0', '0'},
            {'0', '1', '0'},
            {'1', '1', '0'},
    };
    static final char[][] RSF2 = new char[][]{
            {'0', '1', '0', '1'},
            {'1', '1', '1', '0'},
            {'1', '1', '1', '0'},
            {'0', '1', '1', '0'},
            {'1', '0', '0', '0'},
    };
    static final char[][] RSF3 = new char[][]{
            {'1', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'0', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '0'},
            {'1', '0', '1', '1', '0'},
            {'1', '1', '0', '0', '0'},
    };
    static final char[][] RSF4 = new char[][]{
            {'1', '0', '1', '0', '1'},
            {'1', '1', '1', '1', '0'},
            {'0', '1', '1', '1', '0'},
            {'0', '1', '1', '1', '0'},
            {'1', '1', '1', '1', '0'},
            {'1', '0', '1', '1', '0'},
            {'1', '1', '0', '0', '0'},
    };
    static final char[][][] RAUMSCHIFFE =  new char[][][]{
            RSF1, RSF2, RSF3, RSF4
    };

    static final char[][] CHS1 = new char[][]{
            {'0', '0', '0', '1', '0', '0', '0'},
            {'0', '1', '1', '1', '1', '1', '0'},
            {'0', '0', '0', '1', '0', '0', '0'},
    };
    static final char[][] CHS2 = new char[][]{
            {'1', '0', '0'},
            {'0', '0', '1'},
            {'1', '0', '1'},
    };
    static final char[][][] CHAOS =  new char[][][]{
            CHS1, CHS2
    };

    static SchischVisualizer sv = new SchischVisualizer();
    static char[][] welt = MultiArrays.createEmpty2DCharArray(100, 100);

    /**
     * Initialisiert die Game of Life Simulation mit zu c * 100% zufällig platzierten lebendigen Zellen
     * @param c double
     */

    public static void initRandom(double c) {
        Simulationen.fuellen(welt, '1', 1);
        Simulationen.fuellen(welt, '0', '1', c);
        sv.step(welt);
    }

    /**
     * Initialisiert die Game of Life Simulation mit dem o. oszillierenden Objekt
     * @param o int
     */

    public static void initOszillierend(int o) {
        Simulationen.fuellen(welt, '1', 1);

        if (o >= 1 && o <= 8) {
            char[][] oscilator = OSZILLIEREND[o - 1];
            Steine.zeichneTetromino(welt, oscilator, 0, welt.length / 2 - oscilator.length / 2, welt[0].length / 2 - oscilator[0].length / 2);
            sv.step(welt);
        }
    }

    /**
     * Initialisiert die Game of Life Simulation mit dem r. Raumschigg
     * @param r int
     */

    public static void initRaumschiff(int r) {
        Simulationen.fuellen(welt, '1', 1);

        if (r >= 1 && r <= 4) {
            char[][] raumschiff = RAUMSCHIFFE[r - 1];
            Steine.zeichneTetromino(welt, raumschiff, 0, welt.length / 2 - raumschiff.length / 2, welt[0].length / 2 - raumschiff[0].length / 2);
            sv.step(welt);
        }
    }

    /**
     * Initialisiert die Game of Life Simulation mit Chaos
     * @param c int
     */

    public static void initChaos(int c) {
        Simulationen.fuellen(welt, '1', 1);

        if (c >= 1 && c <= 2) {
            char[][] chaos = CHAOS[c - 1];
            Steine.zeichneTetromino(welt, chaos, 0, welt.length / 2 - chaos.length / 2, welt[0].length / 2 - chaos[0].length / 2);
            sv.step(welt);
        }
    }

    /**
     * Führt einen Spielschritt der Game of Life Simulation durch.
     * @param r boolean Rand
     */

    public static void weiter(boolean r) {
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

    /**
     * Führt die Game of Life Simulation durch
     * @param g int Anz. d. Simuloationsschritte
     * @param r boolean
     */

    public static void simulation(int g, boolean r) {
        for (int i = 0; i < g; i++) {
            weiter(r);
        }
    }

    public static void main(String[] args) {
        initRandom(0.4);
        simulation(200, false);
        sv.start();
    }
}