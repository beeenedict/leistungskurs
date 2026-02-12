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

    static int[] oben = new int[spiegel.length - 2];
    static int[] unten = new int[spiegel.length - 2];
    static int[] links = new int[spiegel[0].length - 2];
    static int[] rechts = new int[spiegel[0].length - 2];

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

    public static boolean zieleErreicht() {
        int z = 0;
        for (int i = 1; i < spiegel.length - 1; i++) {
            for (int j = 1; j < spiegel[0].length - 1; j++) {
                if (spiegel[i][j] == ZIEL) {
                    z++;
                }
            }
        }
        return z == 0;
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
        spiegel[20][1] = '<';
        spiegel[17][1] = '>';
        spiegel[20][2] = '<';
        spiegel[18][2] = '^';
        sv.step(spiegel);
    }

    public static void generierePfeil() {
        spiegel[0][spiegel.length/2] = PFEILR;
    }

    public static char einfaerben(int unfaelle) { // '0', '5', 'A', '4', 'F', 'C', '1'
        char farbe = '0';
        if (unfaelle > 10) {
            farbe = '5';
        } if (unfaelle > 20) {
            farbe = 'A';
        } if (unfaelle > 30) {
            farbe = '4';
        } if (unfaelle > 50) {
            farbe = 'F';
        } if (unfaelle > 60) {
            farbe = 'D';
        } if (unfaelle > 70) {
            farbe = 'C';
        } if (unfaelle > 90) {
            farbe = '1';
        }
        return farbe;
    }

    public static void unfall(int x, int y, boolean start, boolean zeichnen) {
        if (start) {
            for (int i = 0; i < oben.length; i++) {
                oben[i] = 0;
                unten[i] = 0;
            }
            for (int i = 0; i < rechts.length; i++) {
                rechts[i] = 0;
                links[i] = 0;
            }
        }
        else if (zeichnen) {
            for (int i = 0; i < oben.length; i++) {
                if (spiegel[i+1][0] != PFEILO) {
                    spiegel[i+1][0] = einfaerben(oben[i]);
                }
                if (spiegel[i+1][spiegel.length - 1] != PFEILU) {
                    spiegel[i+1][spiegel.length - 1] = einfaerben(unten[i]);
                }
            }
            for (int i = 0; i < rechts.length; i++) {
                if (spiegel[0][i+1] != PFEILL && i+1 != spiegel.length/2) {
                    spiegel[0][i+1] = einfaerben(links[i]);
                }
                if (spiegel[spiegel.length - 1][i+1] != PFEILR) {
                    spiegel[spiegel.length - 1][i+1] = einfaerben(rechts[i]);
                }
            }
        }
        else {
            if (x == spiegel.length) {
                rechts[y-1]++;
            }
            if (y == spiegel[0].length) {
                unten[x-1]++;
            }
            if (x < 0) {
                links[y-1]++;
            }
            if (y < 0) {
                oben[x-1]++;
            }
        }
    }

    public static void spiegelSimulation(int abs, double dreh, int pfeile, boolean bisGewonnen) {
        unfall(0, 0, true, false);
        char[][] spiegelAlt;
        do {
            spiegelAlt = MultiArrays.copy2DcharArray(spiegel);
            int richtung;
            int tempx;
            int tempy;

            for (int i = 0; i < spiegel.length; i++) {
                for (int j = 0; j < spiegel[0].length; j++) {
                    if (spiegel[i][j] == PFEILR || spiegel[i][j] == PFEILU || spiegel[i][j] == PFEILL || spiegel[i][j] == PFEILO) {
                        spiegel[i][j] = ' ';
                    }
                }
            }

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
                        char spg;
                        switch (temp) {
                            case '-':
                                unfall(tempx, tempy, false, false);
                                break;
                            case SPIEGEL1:
                                if (Math.random() < dreh) {
                                    spiegel[tempx][tempy] = SPIEGEL2;
                                }
                                if (richtung == 0 || richtung == 3 || richtung == 1) {
                                    richtung = Math.abs(richtung - 1);
                                    spg = Simulationen.getNachbar(spiegelAlt, richtung, tempx, tempy, true);
                                    if (richtung == 1) {
                                        tempx++;
                                    }
                                    if (richtung == 0) {
                                        tempy--;
                                    }
                                    if (richtung == 2) {
                                        tempy++;
                                    }
                                } else {
                                    spg = Simulationen.getWesten(spiegelAlt, tempx, tempy, false);
                                    richtung = 3;
                                    tempx--;
                                }
                                if (spg != ' ') {
                                    spiegel[tempx][tempy] = ' ';
                                } else {
                                    switch (richtung) {
                                        case 0:
                                            spiegel[tempx][tempy] = PFEILO;
                                            break;
                                        case 1:
                                            spiegel[tempx][tempy] = PFEILR;
                                            break;
                                        case 2:
                                            spiegel[tempx][tempy] = PFEILU;
                                            break;
                                        case 3:
                                            spiegel[tempx][tempy] = PFEILL;
                                            break;
                                    }
                                }
                                break;
                            case SPIEGEL2:
                                if (Math.random() < dreh) {
                                    spiegel[tempx][tempy] = SPIEGEL1;
                                }
                                if (richtung == 2) {
                                    richtung--;
                                    spg = Simulationen.getNachbar(spiegelAlt, richtung, tempx, tempy, true);
                                    tempx++;
                                } else if (richtung == 0) {
                                    richtung = 3;
                                    spg = Simulationen.getNachbar(spiegelAlt, richtung, tempx, tempy, true);
                                    tempx--;
                                } else if (richtung == 3) {
                                    richtung = 0;
                                    spg = Simulationen.getNachbar(spiegelAlt, richtung, tempx, tempy, true);
                                    tempy--;
                                } else {
                                    richtung++;
                                    spg = Simulationen.getNachbar(spiegelAlt, richtung, tempx, tempy, true);
                                    tempy++;
                                }
                                if (spg == ZIEL) {
                                    spiegel[tempx][tempy] = ' ';
                                } else {
                                    switch (richtung) {
                                        case 0:
                                            spiegel[tempx][tempy] = PFEILO;
                                            break;
                                        case 1:
                                            spiegel[tempx][tempy] = PFEILR;
                                            break;
                                        case 2:
                                            spiegel[tempx][tempy] = PFEILU;
                                            break;
                                        case 3:
                                            spiegel[tempx][tempy] = PFEILL;
                                            break;
                                    }
                                }
                                break;
                            case ZIEL:
                                spiegel[tempx][tempy] = ' ';
                                break;
                            default:
                                spiegel[tempx][tempy] = pfeil;
                                break;
                        }
                    }
                }
            }
            if (zuege%abs == 0 && (pfeile > 0 || bisGewonnen)) {
                generierePfeil();
                pfeile--;
            }
            zuege++;
            unfall(0, 0, false, true);
            sv.step(spiegel);
            if (zieleErreicht() && (bisGewonnen || pfeile > 0)) {
                if (!bisGewonnen) {
                    System.out.println("Übrige Pfeile: " + pfeile);
                }
                pfeile = 0;
                bisGewonnen = false;
            }
        } while ((!MultiArrays.istIdentisch(spiegel, spiegelAlt) || pfeile > 0 || bisGewonnen) && zuege < 2);
    }

    public static void main(String[] args) {
        zufallSpiegel(0);
        zufallZiele(0);
        spiegelSimulation(10, 0.5, 5, false);
        sv.start();
    }
}
