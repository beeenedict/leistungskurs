package sonstiges;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import blatt14.Steine;
import schisch_visualizer.SchischVisualizer;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class SpielDesLebens {

    static SchischVisualizer sv = new SchischVisualizer();
    static Scanner sc = new Scanner(System.in);
    public static char[][] welt;

    static final char[][] BLOCK = new char[][]{
            {'8', '8'},
            {'8', '8'}
    };

    static final char[][] LOAF = new char[][]{
            {'6', '8', '8', '6'},
            {'8', '6', '6', '8'},
            {'6', '8', '6', '8'},
            {'6', '6', '8', '6'}
    };

    static final char[][] TUB = new char[][]{
            {'6', '8', '6'},
            {'8', '6', '8'},
            {'6', '8', '6'}
    };

    static final char[][] BOAT = new char[][]{
            {'6', '8', '8'},
            {'8', '6', '8'},
            {'6', '8', '6'}
    };

    static final char[][] BEEHIVE = new char[][]{
            {'6', '8', '6'},
            {'8', '6', '8'},
            {'8', '6', '8'},
            {'6', '8', '6'}
    };

    static char[][][] stillLife = new char[][][]{
        BLOCK, LOAF, BOAT, TUB, BEEHIVE
    };

    static final char[][] BLINKER = new char[][]{
            {'0', '0', '0'}
    };

    static final char[][] BIGBLINKER = new char[][]{
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '5', '5', '5', '5', '5'},
            {'8', '8', '8', '5', '5', '5', '8', '8', '8'},
            {'5', '5', '5', '5', '5', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
            {'5', '5', '5', '5', '8', '5', '5', '5', '5'},
    };

    static final char[][] TOAST = new char[][]{
            {'5', '8', '8', '5'},
            {'5', '5', '5', '8'},
            {'8', '5', '5', '5'},
            {'5', '8', '8', '5'},
    };

    static char[][][] oscillators  = new char[][][]{
            BLINKER, BIGBLINKER, TOAST
    };

    static final char[][] GLIDER = new char[][]{
            {'8', '8', '7'},
            {'8', '7', '8'},
            {'8', '7', '7'}
    };

    static final char[][] LIGHTWEIGHT = new char[][]{
            {'8', '8', '8', '8', '8'},
            {'8', '8', '8', '8', '8'},
            {'8', '8', '8', '8', '8'},
            {'8', '8', '8', '8', '8'}
    };

    static char[][][] spaceships  = new char[][][]{
            GLIDER, //LIGHTWEIGHT, MIDDLEWEIGHT, HEAVYWEIGHT
    };

    public static void zeichneFiguren() {
        boolean a = true;

        while (a) {
            a = false;
            System.out.println("Wollen Sie eine Figur erstellen? 0/1");
            int i = sc.nextByte();
            sc.nextLine();
            if (i == 1) {
                a = true;
                System.out.println("Geben Sie den Namen der Figur ein:");
                String name = sc.nextLine();
                name = name.toLowerCase();
                int x = 0;
                int y = 0;
                int r = 0;
                if (!name.isEmpty()) {
                    System.out.println("Wohin soll die Figur platziert werden? (x; y)");
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println("Wie oft soll die Figur um 90° nach rechts gedreht werden?");
                    r = sc.nextInt();
                }

                switch (name) {
                    case "block":
                        figuren(x, y, stillLife[0], r);
                        break;
                    case "loaf":
                        figuren(x, y, stillLife[1], r);
                        break;
                    case "boat":
                        figuren(x, y, stillLife[2], r);
                        break;
                    case "tub":
                        figuren(x, y, stillLife[3], r);
                        break;
                    case "beehive":
                        figuren(x, y, stillLife[4], r);
                        break;
                    case "blinker":
                        figuren(x, y, oscillators[0], r);
                        break;
                    case "big blinker":
                        figuren(x, y, oscillators[1], r);
                        break;
                    case "toad":
                        figuren(x, y, oscillators[2], r);
                        break;
                    case "glider":
                        figuren(x, y, spaceships[0], r);
                        break;
                    case "lightweight":
                        figuren(x, y, spaceships[1], r);
                        break;
                    case "middleweight":
                        figuren(x, y, spaceships[2], r);
                        break;
                    case "heavyweight":
                        figuren(x, y, spaceships[3], r);
                        break;
                }
            }
        }
    }

    public static void spielDesLebens(int x, int y, double c) {
        welt = MultiArrays.createEmpty2DCharArray(x, y);
        Simulationen.fuellen(welt, '1', 1);
        zeichneFiguren();
        Simulationen.fuellen(welt, '0', '1', c);
        for (int i = 0; i < welt.length; i++) {
            for (int j = 0; j < welt[0].length; j++) {
                if (welt[i][j] == '8') {
                    welt[i][j] = '0';
                }
                if (welt[i][j] != '0') {
                    welt[i][j] = '1';
                }
            }
        }
        sv.step(welt);
    }

    public static void leben(boolean u) {
        System.out.println("Wieviele Generationen möchten Sie simulieren?");
        int g = sc.nextInt();
        for (int i = 0; i < g; i++) {
            char[][] vergangenheit = MultiArrays.copy2DcharArray(welt);

            for (int j = 0; j < welt.length; j++) {
                for (int k = 0; k < welt[j].length; k++) {
                    if (vergangenheit[j][k] == '1') {
                        if (Simulationen.zaehlenAcht(vergangenheit, '0', j, k, u) == 3) {
                            welt[j][k] = '0';
                        }
                    }
                    else {
                        if (Simulationen.zaehlenAcht(vergangenheit, '0', j, k, u) < 2 || Simulationen.zaehlenAcht(vergangenheit, '0', j, k, u) > 3) {
                            welt[j][k] = '1';
                        }
                    }
                }
            }
            sv.step(welt);
        }
    }

    public static void figuren(int x, int y, char[][] fig, int r) {
        Steine.zeichneTetromino(welt, fig, r, x, y);
        sv.step(welt);
    }

    public static void main(String[] args) {
        spielDesLebens(300, 200, 0.175);
        leben(true);
        sv.start();
    }
}
