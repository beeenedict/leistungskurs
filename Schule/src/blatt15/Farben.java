package blatt15;

import blatt13.Zufall;
import blatt14.MultiArrays;
import schisch_visualizer.SchischVisualizer;

public class Farben {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] spielfeld;
    static int[] spielerPosX = new int[8];
    static int[] spielerPosY = new int[8];

    public static void initialisiereSpielfeld(int x, int y) {
        spielfeld = MultiArrays.createEmpty2DCharArray(x, y);

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (i == 0 || j == 0 || i == x - 1 || j == y - 1) {
                    spielfeld[i][j] = '8';
                }
            }
        }

        sv.step(spielfeld);
    }

    public static void startPositionen() {

        for (int i = 0; i < spielerPosX.length; i++) {
            spielerPosY[i] = Zufall.zufallGanz(1, spielfeld[0].length - 2);
            if (i < 4) {
                spielerPosX[i] = Zufall.zufallGanz(1, spielfeld.length / 2);
            } else {
                spielerPosX[i] = Zufall.zufallGanz(spielfeld.length / 2 + 1, spielfeld.length - 2);
            }
            while (spielfeld[spielerPosX[i]][spielerPosY[i]] != ' ') {
                spielerPosY[i] = Zufall.zufallGanz(1, spielfeld[0].length - 2);
            }
            spielfeld[spielerPosX[i]][spielerPosY[i]] = 'P';
        }

        sv.step(spielfeld);
    }

    public static int zaehlen (int team) {
        int farbe = 0;

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (team == 0 && spielfeld[i][j] == ' ') {
                    farbe++;
                }
                if (team == 1 && spielfeld[i][j] == '7') {
                    farbe++;
                }
                if (team == 2 && spielfeld[i][j] == '9') {
                    farbe++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (team == 1 && spielerPosX[i] > -1) {
                farbe++;
            }
            if (team == 2 && spielerPosX[i + 4] > -1) {
                farbe++;
            }
        }

        return farbe;
    }

    public static void respawn(int spieler) {

    }

    public static void main(String[] args) {
        initialisiereSpielfeld(80, 80);
        startPositionen();
        sv.start();
    }
}
