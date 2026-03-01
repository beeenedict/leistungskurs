package blatt17;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class LangtonsAmeise {

    static SchischVisualizer sv = new SchischVisualizer();
    static char[][] ameisenhaufen;

    /**
     * Initialisiert den Ameisenhaufen mit dem Maßen x * y
     * @param x int
     * @param y int
     * @param c double Wahrscheinlichkeit Sand
     */

    public static void initAmeisenhaufen(int x, int y, double c) {
        ameisenhaufen = MultiArrays.createEmpty2DCharArray(x, y);

        Simulationen.fuellen(ameisenhaufen, '0', 1);
        Simulationen.fuellen(ameisenhaufen, '1', '0', c);

        ameisenhaufen[ameisenhaufen.length / 2][ameisenhaufen[0].length / 2] = 'v';
        sv.step(ameisenhaufen);
    }

    /**
     * Führt die Ameisensimulation durch
     * @param s int
     */

    public static void ameisensimulation(int s) {
        int x = ameisenhaufen.length / 2;
        int y = ameisenhaufen[0].length / 2;
        char feld;
        char feldAlt = '0';
        int r = 2;
        char ameise;

        for (int i = 0; i < s; i++) {
            ameise = ameisenhaufen[x][y];
            ameisenhaufen[x][y] = feldAlt;
            switch(ameise) {
                case 'v':
                    feld = Simulationen.getSueden(ameisenhaufen, x, y, true);
                    y++;
                    if (y == ameisenhaufen[0].length) {
                        y = 0;
                    }
                    break;
                case '>':
                    feld = Simulationen.getOsten(ameisenhaufen, x, y, true);
                    x++;
                    if (x == ameisenhaufen.length) {
                        x = 0;
                    }
                    break;
                case '<':
                    feld = Simulationen.getWesten(ameisenhaufen, x, y, true);
                    x--;
                    if (x < 0) {
                        x = ameisenhaufen.length - 1;
                    }
                    break;
                default:
                    feld = Simulationen.getNorden(ameisenhaufen, x, y, true);
                    y--;
                    if (y < 0) {
                        y = ameisenhaufen[0].length - 1;
                    }
            }
            if (ameise == '^' && feld == '0' || ameise == 'v' && feld == '1') {
                ameisenhaufen[x][y] = '>';
            }
            else if (ameise == '>' && feld == '0' || ameise == '<' && feld == '1') {
                ameisenhaufen[x][y] = 'v';
            }
            else if (ameise == '>' && feld == '1' || ameise == '<' && feld == '0') {
                ameisenhaufen[x][y] = '^';
            }
            else if (ameise == '^'  && feld == '1' || ameise == 'v' && feld == '0') {
                ameisenhaufen[x][y] = '<';
            }
            if (feld == '1') {
                feldAlt = '0';
            }
            if (feld == '0') {
                feldAlt = '1';
            }
            sv.step(ameisenhaufen);
        }
    }

    public static void main(String[] args) {
        initAmeisenhaufen(100, 100, 0.50);
        ameisensimulation(9000);
        sv.start();
    }
}