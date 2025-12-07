package blatt14;

import blatt13.Zufall;
import schisch_visualizer.SchischVisualizer;

public class OasenSuche {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] spielfeld;
    static int[] positionSpieler = new int[2];

    public static void initialisiereSpielfeld(int a, int b) {
        if(spielfeld == null) {
            spielfeld = MultiArrays.createEmpty2DCharArray(a, b);
            sv.step(spielfeld);
        }
    }

    public static void zufallsPositionSpieler() {
        if (spielfeld != null) {
            positionSpieler[0] = Zufall.zufallGanz(spielfeld.length);
            positionSpieler[1] = Zufall.zufallGanz(spielfeld[0].length);
            spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
            sv.step(spielfeld);
        }
    }

    public static void wasserZufall(double c) {
        c = Math.round(c * 100.0);
        boolean wasser;
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                wasser = Zufall.zufallGanz(99) <= c;
                if (wasser && spielfeld[i][j] != 'P') {
                    spielfeld[i][j] = '2';
                    sv.step(spielfeld);
                }
            }
        }
    }

    public static void steinZufall(double c) {
        c = Math.round(c * 100.0);
        boolean stein;
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                stein = Zufall.zufallGanz(99) <= c;
                if (stein && spielfeld[i][j] != 'P' && spielfeld[j][i] != '2') {
                    spielfeld[i][j] = '1';
                    sv.step(spielfeld);
                }
            }
        }
    }

    public static boolean wasserGefunden() {
        if (positionSpieler[0] < spielfeld.length - 1 && positionSpieler[0] > 0 && positionSpieler[1] < spielfeld[0].length - 1 && positionSpieler[1] > 0) {
            return spielfeld[positionSpieler[0] + 1][positionSpieler[1]] == '2' || spielfeld[positionSpieler[0] - 1][positionSpieler[1]] == '2' || spielfeld[positionSpieler[0]][positionSpieler[1] + 1] == '2' || spielfeld[positionSpieler[0] + 1][positionSpieler[1] - 1] == '2';
        }
        else
    }

    public static void findeWasser(int energie) {
        boolean wasser = false;
        int[] letzterSchritt = new int[2];
        for (int i = 0; i < energie; i++) {
            if (wasserGefunden())
            if (i == 0) {

            }
            else {

            }
            letzterSchritt = positionSpieler;
        }
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(60, 60);
        zufallsPositionSpieler();
        wasserZufall(0.03);
        steinZufall(0.15);
        sv.start();
    }
}
