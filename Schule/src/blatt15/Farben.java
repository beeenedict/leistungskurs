package blatt15;

import blatt07.ArbeitMitArrays;
import blatt13.Zufall;
import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class Farben {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] spielfeld;
    static int[] spielerPosX = new int[8];
    static int[] spielerPosY = new int[8];
    static int[] reihenfolge = new int[8];

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

    public static void respawn(int spieler, int team) {
        char farbe = ' ';
        int uebrigeFarbe = 0;

        if (team == 1) {
            farbe = '7';
        }
        if (team == 2) {
            farbe = '9';
        }

        if (zaehlen(team) > 0) {

            int random = Zufall.zufallGanz(6400);

            spielerPosX[spieler] = 0;
            spielerPosY[spieler] = 0;

            while (random > 0) {
                for (int i = 0; i < spielfeld.length; i++) {
                    for (int j = 0; j < spielfeld[i].length; j++) {
                        if (spielfeld[i][j] == farbe) {
                            random--;
                            if (random == 0) {
                                spielerPosX[spieler] = i;
                                spielerPosY[spieler] = j;
                                spielfeld[i][j] = 'P';
                            }
                        }
                    }
                }
            }
        }
        else {
            int x;
            int y;
            do {
                x = Zufall.zufallGanz(1, 80);
                y = Zufall.zufallGanz(1, 80);
            } while (spielfeld[x][y] == 'P');

            spielerPosX[spieler] = x;
            spielerPosY[spieler] = y;
            spielfeld[x][y] = 'P';
        }
    }

    public static void reihenfolge() {
        int position;

        for (int i = 0; i < reihenfolge.length; i++) {
            reihenfolge[i] = -1;
        }

        for (int i = 0; i < reihenfolge.length; i++) {
            do {
                position = Zufall.zufallGanz(7);
            } while (reihenfolge[position] != -1);
            reihenfolge[position] = i;
        }
    }

    public static void zugEins(int spieler) {
        char farbe = '7';
        boolean team = false;
        int spielernr = spieler;

        if (spieler > 3) {
            farbe = '9';
            team = true;
        }

        int xd = 20;
        int yd1 = 20;
        int yd2 = 60;

        int xa = 60;
        int ya1 = 20;
        int ya2 = 60;

        if (team) {
            xd += 40;
            xa -= 40;
            spieler -= 4;
        }

        int x = spielerPosX[spieler];
        int y = spielerPosY[spieler];
        char[] sichtfeld = new char[12];

        sichtfeld[8] = Simulationen.getNorden(spielfeld, x, y - 1, false);
        sichtfeld[11] = Simulationen.getWesten(spielfeld, x-1, y, false);
        sichtfeld[9] = Simulationen.getOsten(spielfeld, x+1, y, false);
        sichtfeld[10] = Simulationen.getSueden(spielfeld, x, y+1, false);

        sichtfeld[5] = Simulationen.getNordWest(spielfeld, x, y, false);
        sichtfeld[0] = Simulationen.getNorden(spielfeld, x, y, false);
        sichtfeld[4] = Simulationen.getNordOst(spielfeld, x, y, false);
        sichtfeld[3] = Simulationen.getOsten(spielfeld, x, y, false);
        sichtfeld[1] = Simulationen.getWesten(spielfeld, x, y, false);
        sichtfeld[7] = Simulationen.getSuedOst(spielfeld, x, y, false);
        sichtfeld[2] = Simulationen.getSueden(spielfeld, x, y, false);
        sichtfeld[6] = Simulationen.getSuedWest(spielfeld, x, y, false);

        /*
                8
             7  0  4
          11 3 'P' 1  9
             6  2  5
                10
         */

        int richtung = 0;

        /*
            -1 -> oben
            1 -> unten
            -2 -> links
            2 -> rechts
         */

        if (spieler == 0 || spieler == 1) {
            if (spielerPosX[spielernr] != xd) {
                if (spielerPosX[spielernr] < xd) {
                    richtung = 2;
                }
                else {
                    richtung = -2;
                }
            }
            else if (spieler == 0 && spielerPosY[spielernr] != yd1) {
                if (spielerPosY[spielernr] < yd1) {
                    richtung = 1;
                }
                else {
                    richtung = -1;
                }
            }
            else if (spieler == 1 && spielerPosX[spielernr] != yd2) {
                if (spielerPosY[spielernr] < yd2) {
                    richtung = 1;
                }
                else {
                    richtung = -1;
                }
            }
            else {
                //Spirale
            }
        }
        else {
            //Angreifer
        }

        // spieler platzieren

        spielfeld[spielerPosX[spieler]][spielerPosY[spieler]] = farbe;
        switch (richtung) {
            case -1:
                spielerPosY[spieler]--;
                break;
            case 1:
                spielerPosY[spieler]++;
                break;
            case -2:
                spielerPosX[spieler]--;
                break;
            case 2:
                spielerPosX[spieler]++;
        }
        spielfeld[spielerPosX[spieler]][spielerPosY[spieler]] = 'P';
    }

    public static void zugZwei(int spieler) {
        char farbe = '9';

        if (spieler < 4) {
            farbe = '7';
        }

        int richtung;

        do {
            richtung = Zufall.zufallGanz(0, 5) - 2;
        } while (richtung == 0 || spielerPosX[spieler] + richtung < 0 || spielerPosX[spieler] + richtung > 81 || spielerPosY[spieler] + richtung < 1 || spielerPosY[spieler] + richtung > 80);

        spielfeld[spielerPosX[spieler]][spielerPosY[spieler]] = farbe;
        switch (richtung) {
            case -1:
                spielerPosY[spieler]--;
                break;
            case 1:
                spielerPosY[spieler]++;
                break;
            case -2:
                spielerPosX[spieler]--;
                break;
            case 2:
                spielerPosX[spieler]++;
        }
        spielfeld[spielerPosX[spieler]][spielerPosY[spieler]] = 'P';
    }

    public static void main(String[] args) {
        initialisiereSpielfeld(82, 82);
        startPositionen();
        reihenfolge();
        for (int j = 0; j < 1000; j++) {
            for (int i = 0; i < reihenfolge.length; i++) {
                if(i >= 4) {
                    zugEins(i);
                }
                else {
                    zugZwei(i);
                }
            }
            sv.step(spielfeld);
        }
        sv.start();
    }
}