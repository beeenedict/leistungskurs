package blatt15;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

import java.util.Scanner;

public class KaeseKomplex {
    static SchischVisualizer sv = new SchischVisualizer();

    static char[][][] kaese;

    public static void initialisiereKaese() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie breit soll der Käse sein?");
        int x = input.nextInt();
        System.out.println("Wie hoch soll der Käse sein?");
        int y = input.nextInt();
        System.out.println("Wie tief soll der Käse sein?");
        int z = input.nextInt();
        System.out.println("Wie löchrig soll der Käse sein? (%)");
        double c = input.nextDouble();
        c /= 100;

        kaese = new char[z][x][y];
        for (int i = 0; i < z; i++) {
            kaese[i] = MultiArrays.createEmpty2DCharArray(x, y + 2);
        }

        for(int k = 0; k < z; k++) {
            for (int i = 0; i < kaese.length; i++) {
                for (int j = 1; j < y + 1; j++) {
                    if (Math.random() > c) {
                        kaese[k][i][j] = '5';
                    }
                }
            }
        }
    }

    public static void kaeseFluten() {

        char[][][] kaeseAlt = MultiArrays.copy3DcharArray(kaese);

        for (int i = 0; i < kaese.length; i++) {
            for (int j = 0; j < kaese[i].length; j++) {
                kaese[i][j][0] = '2';
            }
        }

        while (!MultiArrays.istIdentisch3D(kaese, kaeseAlt)) {
            kaeseAlt = MultiArrays.copy3DcharArray(kaese);

            for (int k = 0; k < kaese.length; k++) {
                for (int i = 0; i < kaese[k].length; i++) {
                    for (int j = 0; j < kaese[k][0].length; j++) {
                        if (kaeseAlt[k][i][j] == '2') {
                            if (Simulationen.getNorden(kaeseAlt[k], i, j, false) == ' ') {
                                kaese[k][i][j - 1] = '2';
                            }
                            if (Simulationen.getSueden(kaeseAlt[k], i, j, false) == ' ') {
                                kaese[k][i][j + 1] = '2';
                            }
                            if (Simulationen.getWesten(kaeseAlt[k], i, j, false) == ' ') {
                                kaese[k][i - 1][j] = '2';
                            }
                            if (Simulationen.getOsten(kaeseAlt[k], i, j, false) == ' ') {
                                kaese[k][i + 1][j] = '2';
                            }
                            if (k < kaese.length - 1 && kaeseAlt[k + 1][i][j] == ' ') {
                                kaese[k + 1][i][j] = '2';
                            }
                            if (k > 0 && kaeseAlt[k - 1][i][j] == ' ') {
                                kaese[k - 1][i][j] = '2';
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < kaese.length; i++) {
            sv.step(kaese[i]);
        }
    }

    public static void istWasserdicht(int z) {
        if (kaese[0][0][kaese[0].length - 1] == '2') {
            System.out.println("Der Käse ist nicht Wasserdicht!");
        }
        else {
            System.out.println("Der Käse ist Wasserdicht!");
        }
    }

    public static void main(String[] args) {
        initialisiereKaese();
        kaeseFluten();
        sv.start();
    }
}
