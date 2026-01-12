package blatt15;

import schisch_visualizer.SchischVisualizer;

import java.util.Scanner;

public class Kaese {

    static SchischVisualizer sv = new SchischVisualizer();

    public static char[][] initialisiereKaese() {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie hoch soll der Käse sein?");
        int a = input.nextInt();
        System.out.println("Wie breit soll der Käse sein?");
        int b = input.nextInt();
        System.out.println("Wie löchrig soll der Käse sein? (%)");
        double c = input.nextDouble();

        char[][] kaese = new char[a][b + 2];

        for (int i = 0; i < kaese.length; i++) {
            kaese[i][0] = '';
        }

        return kaese;
    }

    public static void kaeseFluten(char[][] gefaess) {

    }

    public static void main(String[] args) {
        kaeseFluten(initialisiereKaese());
        sv.start();
    }
}
