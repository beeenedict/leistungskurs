package blatt14;

import blatt13.Zufall;
import schisch_visualizer.SchischVisualizer;

public class OasenSuche {

    static SchischVisualizer sv = new SchischVisualizer();
    static int n = 0;
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
            int i = Zufall.zufallGanz(spielfeld.length-1);
            int j = Zufall.zufallGanz(spielfeld[i].length-1);
            positionSpieler[0] = i;
            positionSpieler[1] = j;
            spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
            sv.step(spielfeld);
        }
    }

    public static void wasserZufall(double c) {
        if (spielfeld != null) {
            Simulationen.fuellen(spielfeld, '2', c);
            sv.step(spielfeld);
        }
    }

    public static void steinZufall(double c) {
        if (spielfeld != null) {
            Simulationen.fuellen(spielfeld, '1', ' ', c);
            sv.step(spielfeld);
        }
    }

    public static boolean wasserGefunden() {
        return Simulationen.zaehlenVier(spielfeld, '2', positionSpieler[0], positionSpieler[1], true) > 0;
    }

    public static void findeWasser(int energie) {
        int p;
        for (int i = 0; i < energie; i++) {
            if (wasserGefunden()) {
                System.out.println("Yay");
                break;
            }
            else {
                for (p = 0; p < 2; p++) {
                    spielfeld[positionSpieler[0]][positionSpieler[1]] = 'F';
                    if (Simulationen.getNorden(spielfeld, positionSpieler[0], positionSpieler[1], true) == ' ' || (p == 1 && Simulationen.getNorden(spielfeld, positionSpieler[0], positionSpieler[1], true) == 'F')) {
                        if (positionSpieler[1] > 0) {
                            positionSpieler[1]--;
                        }
                        else {
                            positionSpieler[1] = spielfeld.length - 1;
                        }
                        spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
                        break;
                    }
                    else if (Simulationen.getOsten(spielfeld, positionSpieler[0], positionSpieler[1], true) == ' ' || (p == 1 && Simulationen.getOsten(spielfeld, positionSpieler[0], positionSpieler[1], true) == 'F')) {
                        if (positionSpieler[0] < spielfeld.length - 1) {
                            positionSpieler[0]++;
                        }
                        else {
                            positionSpieler[0] = 0;
                        }
                        spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
                        break;
                    }
                    else if (Simulationen.getWesten(spielfeld, positionSpieler[0], positionSpieler[1], true) == ' ' || (p == 1 && Simulationen.getWesten(spielfeld, positionSpieler[0], positionSpieler[1], true) == 'F')) {
                        if (positionSpieler[0] > 0) {
                            positionSpieler[0]--;
                        }
                        else {
                            positionSpieler[0] = spielfeld.length - 1;
                        }
                        spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
                        break;
                    }
                    else if (Simulationen.getSueden(spielfeld, positionSpieler[0], positionSpieler[1], true) == ' ' || (p == 1 && Simulationen.getSueden(spielfeld, positionSpieler[0], positionSpieler[1], true) == 'F')) {
                        if (positionSpieler[1] < spielfeld.length - 1) {
                            positionSpieler[1]++;
                        }
                        else {
                            positionSpieler[1] = 0;
                        }
                        spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
                        break;
                    }
                    else if (p == 1) {
                        spielfeld[positionSpieler[0]][positionSpieler[1]] = 'P';
                        break;
                    }
                }
                sv.step(spielfeld);
            }
        }
        if (!wasserGefunden()) {
            n++;
            System.out.println("Press 'f' to pay respect");
        }
    }

    public static void main(String[] args) {
        int x = 100;
        for (int i = 0; i < x; i++) {
            initialisiereSpielfeld(60, 60);
            zufallsPositionSpieler();
            wasserZufall(0.01);
            steinZufall(0.20);
            findeWasser(50);
            spielfeld = MultiArrays.createEmpty2DCharArray(60, 60);
        }
        System.out.println((double) n / x * 100 + "% sterben.");
        sv.start();
    }
}
