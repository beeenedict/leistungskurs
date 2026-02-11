package blatt15;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class Spiegel {

    static char[][] spiegel = MultiArrays.createEmpty2DCharArray(40,40);
    static final char SPIEGEL1 = '/';
    static final char SPIEGEL2 = '\\';
    static final char ZIEL = 'O';

    static final char PFEILO = '^';
    static final char PFEILR = '>';
    static final char PFEILL = '<';
    static final char PFEILU = 'v';

    static int zuege = 0;

    static SchischVisualizer sv = new SchischVisualizer();

    public static void zufallSpiegel(double c) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[0].length - 1; j++) {
                if (Math.random() < c) {
                    if (Simulationen.zaehlenVier(spiegel, SPIEGEL1, i, j, false) == 0 && Simulationen.zaehlenVier(spiegel, SPIEGEL2, i, j, false) == 0) {
                        if (Math.random() > 0.5) {
                            spiegel[i][j] = SPIEGEL1;
                        } else {
                            spiegel[i][j] = SPIEGEL2;
                        }
                    }
                }
            }
        }
        sv.step(spiegel);
    }

    public static void zufallSpiegelSchwer(double c) {
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

    public static void zufallZiele(double c) {
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[0].length - 1; j++) {
                if (Math.random() < c) {
                    if (spiegel[i][j] != SPIEGEL1 && spiegel[i][j] != SPIEGEL2) {
                        spiegel[i][j] = 'O';
                    }
                }
            }
        }
        sv.step(spiegel);
    }

    public static void generierePfeil() {
        spiegel[0][spiegel.length/2] = PFEILR;
    }

    public static void spiegelSimulation(int abs) {
        char[][] spiegelAlt;
        do {
            spiegelAlt = MultiArrays.copy2DcharArray(spiegel);
            int richtung;
            int tempx;
            int tempy;
            for (int i = 0; i < spiegel.length; i++) {
                for (int j = 0; j < spiegel[0].length; j++) {
                    richtung = -1;
                    tempx = i;
                    tempy = j;
                    char pfeil = spiegelAlt[i][j];
                    switch (pfeil) {
                        case PFEILR:
                            richtung = 1;
                            tempx++;
                            break;
                        case PFEILL:
                            richtung = 3;
                            tempx--;
                            break;
                        case PFEILO:
                            richtung = 0;
                            tempy--;
                            break;
                        case PFEILU:
                            richtung = 2;
                            tempy++;
                            break;
                    }
                    if (richtung != -1) {
                        char temp = Simulationen.getNachbar(spiegelAlt, richtung, i, j, false);
                        switch (temp) {
                            case '-':
                                spiegel[i][j] = ' ';
                                break;
                            case SPIEGEL1:

                                break;
                            case SPIEGEL2:

                                break;
                            case ' ':
                                spiegel[i][j] = ' ';
                                spiegel[tempx][tempy] = pfeil;
                                break;
                            default:
                                spiegel[i][j] = ' ';
                                spiegel[tempx][tempy] = ' ';
                        }
                    }
                }
            }
            if (zuege%abs == 0) {
                generierePfeil();
            }
            zuege++;
            sv.step(spiegel);
        } while (!MultiArrays.istIdentisch(spiegel, spiegelAlt) && zuege < 5);
    }

    public static void main(String[] args) {
        zufallSpiegel(0.2);
        zufallZiele(0.15);
        spiegelSimulation(3);
        sv.start();
    }
}
