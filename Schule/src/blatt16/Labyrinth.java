package blatt16;

import blatt07.ArbeitMitArrays;
import blatt14.MultiArrays;
import blatt14.Simulationen;
import blatt15.Farben;
import schisch_visualizer.SchischVisualizer;

import java.util.Scanner;

public class Labyrinth {
    static SchischVisualizer sv = new SchischVisualizer();

    public static char[][] leseLabyrinth(int n) {
        if (n < 10) {
            return Stroeme.readCharArray("laby0" + n + ".txt");
        }
        else {
            return Stroeme.readCharArray("laby" + n + ".txt");
        }
    }

    public static int[] findeSpieler(char[][] arr) {
        int[] spielerPos = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 'P') {
                    spielerPos[0] = i;
                    spielerPos[1] = j;
                    return spielerPos;
                }
            }
        }
        return spielerPos;
    }

    public static int ersteRichtung(char[] sicht) {
        char[] prioritaet = new char[]{'7', '0', '8', '^', '>', 'v', '<'};
        for (int i = 0; i < prioritaet.length; i++) {
            for (int j = 0; j < sicht.length; j++) {
                if (sicht[j] == prioritaet[i]) {
                    return j;
                }
            }
        }
        return -1;
    }

    public static void spielerPlatzieren(int r, int[] spielerPos, char[][] feld) {
        switch (r) {
            case 0:
                spielerPos[1]--;
                break;
            case 1:
                spielerPos[0]++;
                break;
            case 2:
                spielerPos[1]++;
                break;
            default:
                spielerPos[0]--;
        }
        feld[spielerPos[0]][spielerPos[1]] = 'P';
    }

    public static int charZaehlen(char[][] feld, char c) {
        int anz = 0;

        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[0].length; j++) {
                if (feld[i][j] == c) {
                    anz++;
                }
            }
        }
        return anz;
    }

    public static int labyrinthSimulation(int n) {
        char[][] labyrinth = leseLabyrinth(n);
        sv.step(labyrinth);

        Simulationen.fuellen(labyrinth, 'P', '9', 1);
        int[] spielerPos = findeSpieler(labyrinth);
        sv.step(labyrinth);

        char[] sichtfeld = new char[4];
        int schritte = 0;
        boolean gewonnen = false;
        int r = 0;

        while (charZaehlen(labyrinth, '0') > 0 && schritte < 1000) {
            for (int i = 0; i < sichtfeld.length; i++) {
                sichtfeld[i] = Simulationen.getNachbar(labyrinth, i, spielerPos[0], spielerPos[1], false);
            }

            int s = Simulationen.zaehlenVier(labyrinth, '1', spielerPos[0], spielerPos[1], false) + Simulationen.zaehlenVier(labyrinth, '4', spielerPos[0], spielerPos[1], false);

            if (Simulationen.getNorden(labyrinth, spielerPos[0], spielerPos[1], false) == '<' || Simulationen.getNorden(labyrinth, spielerPos[0], spielerPos[1], false) == '>' || Simulationen.getNorden(labyrinth, spielerPos[0], spielerPos[1], false) == '^') {
                s++;
            }
            if (Simulationen.getOsten(labyrinth, spielerPos[0], spielerPos[1], false) == 'v' || Simulationen.getOsten(labyrinth, spielerPos[0], spielerPos[1], false) == '>' || Simulationen.getOsten(labyrinth, spielerPos[0], spielerPos[1], false) == '^') {
                s++;
            }
            if (Simulationen.getSueden(labyrinth, spielerPos[0], spielerPos[1], false) == '<' || Simulationen.getSueden(labyrinth, spielerPos[0], spielerPos[1], false) == '>' || Simulationen.getSueden(labyrinth, spielerPos[0], spielerPos[1], false) == 'v') {
                s++;
            }
            if (Simulationen.getWesten(labyrinth, spielerPos[0], spielerPos[1], false) == '<' || Simulationen.getWesten(labyrinth, spielerPos[0], spielerPos[1], false) == 'v' || Simulationen.getWesten(labyrinth, spielerPos[0], spielerPos[1], false) == '^') {
                s++;
            }

            if (s == 4) {
                System.out.println("Labyrinth nicht möglich!");
                return schritte;
            }
            else if (s == 3) {
                labyrinth[spielerPos[0]][spielerPos[1]] = '4';
                r = ersteRichtung(sichtfeld);
            }
            else if (Simulationen.zaehlenVier(labyrinth, '0', spielerPos[0], spielerPos[1], false) > 1) {
                r = ersteRichtung(sichtfeld);
                switch (r) {
                    case 0:
                        labyrinth[spielerPos[0]][spielerPos[1]] = '^';
                        break;
                    case 1:
                        labyrinth[spielerPos[0]][spielerPos[1]] = '>';
                        break;
                    case 2:
                        labyrinth[spielerPos[0]][spielerPos[1]] = 'v';
                        break;
                    default:
                        labyrinth[spielerPos[0]][spielerPos[1]] = '<';
                }
            }
            else if (Simulationen.zaehlenVier(labyrinth, '7', spielerPos[0], spielerPos[1], false) == 1) {
                labyrinth[spielerPos[0]][spielerPos[1]] = '8';
                r = ersteRichtung(sichtfeld);
                gewonnen = true;
            }
            else {
                labyrinth[spielerPos[0]][spielerPos[1]] = '8';
                r = ersteRichtung(sichtfeld);
            }
            spielerPlatzieren(r, spielerPos, labyrinth);
            schritte++;
            sv.step(labyrinth);
            if (gewonnen) {
                break;
            }
        }
        return schritte;
    }

    public static boolean istMoeglich(int n) {
        char[][] labyrinth = leseLabyrinth(n);
        sv.step(labyrinth);
        char[][] labyAlt;

        do {
            labyAlt = MultiArrays.copy2DcharArray(labyrinth);

            for (int i = 0; i < labyrinth.length; i++) {
                for (int j = 0; j < labyrinth[0].length; j++) {
                    if (labyAlt[i][j] == '7') {
                        if (Simulationen.getNorden(labyAlt, i, j, false) == '0') {
                            labyrinth[i][j - 1] = '7';
                        }
                        if (Simulationen.getSueden(labyAlt, i, j, false) == '0') {
                            labyrinth[i][j + 1] = '7';
                        }
                        if (Simulationen.getWesten(labyAlt, i, j, false) == '0') {
                            labyrinth[i - 1][j] = '7';
                        }
                        if (Simulationen.getOsten(labyAlt, i, j, false) == '0') {
                            labyrinth[i + 1][j] = '7';
                        }
                    }
                }
            }
            sv.step(labyrinth);
        } while (!MultiArrays.istIdentisch(labyrinth, labyAlt));

        Simulationen.fuellen(labyrinth, 'P', '9', 1);
        int[] spielerPos = findeSpieler(labyrinth);

        return Simulationen.zaehlenVier(labyrinth, '7', spielerPos[0], spielerPos[1], false) >= 1;
    }

    public static void main(String[] args) {
        System.out.println(labyrinthSimulation(4));
        sv.start();
    }
}
