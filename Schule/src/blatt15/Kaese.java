package blatt15;

import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

import java.util.Scanner;

public class Kaese {

    static SchischVisualizer sv = new SchischVisualizer();

    static char[][] kaese;

    public static void initialisiereKaese() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie breit soll der Käse sein?");
        int a = input.nextInt();
        System.out.println("Wie hoch soll der Käse sein?");
        int b = input.nextInt();
        System.out.println("Wie löchrig soll der Käse sein? (%)");
        double c = input.nextDouble();
        c /= 100;

        kaese = MultiArrays.createEmpty2DCharArray(a, b + 2);

        for (int i = 0; i < kaese.length; i++) {
            for (int j = 1; j < b + 1; j++) {
                if (Math.random() > c) {
                    kaese[i][j] = '5';
                }
            }
        }
        sv.step(kaese);
    }

    public static void kaeseFluten() {
        char[][] kaeseAlt = MultiArrays.copy2DcharArray(kaese);

        for (int i = 0; i < kaese.length; i++) {
            kaese[i][0] = '2';
        }
        sv.step(kaese);

        while (!MultiArrays.istIdentisch(kaese, kaeseAlt)) {
            kaeseAlt = MultiArrays.copy2DcharArray(kaese);

            for (int i = 0; i < kaese.length; i++) {
                for (int j = 0; j < kaese[0].length; j++) {
                    if (kaeseAlt[i][j] == '2') {
                        if (Simulationen.getNorden(kaeseAlt, i, j, false) == ' ') {
                            kaese[i][j - 1] = '2';
                        }
                        if (Simulationen.getSueden(kaeseAlt, i, j, false) == ' ') {
                            kaese[i][j + 1] = '2';
                        }
                        if (Simulationen.getWesten(kaeseAlt, i, j, false) == ' ') {
                            kaese[i - 1][j] = '2';
                        }
                        if (Simulationen.getOsten(kaeseAlt, i, j, false) == ' ') {
                            kaese[i + 1][j] = '2';
                        }
                    }
                }
            }
            sv.step(kaese);
        }

        istWasserdicht(kaese);
    }

    public static void istWasserdicht(char[][] kaese) {
        if (kaese[0][kaese[0].length - 1] == '2') {
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
