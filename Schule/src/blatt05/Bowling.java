package blatt05;

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int frames = 0;
        int punkte = 0;
        int pins;
        int wurf;
        int multiplyer = 0;
        int treffer;
        int multi;

        while (frames < 11) {
            if (frames != 10) {
                System.out.println("\n-- Frame " + (frames + 1) + " --");
            }
            pins = 10;
            wurf = 0;
            if (frames == 10) {
                wurf++;
            }
            while (wurf < 2) {
                if (multiplyer > 0) {
                    multiplyer--;
                    multi = 2;
                    if (multiplyer >= 3) {
                        multiplyer -= 2;
                        multi++;
                    }
                }
                else {
                    multi = 1;
                }
                if (frames == 10) {
                    System.out.println("Wurf 3: Wieviele Pins haben Sie diesen Wurf umgeworfen? (0-10)");
                }
                else {
                    System.out.println("Wurf " + (wurf + 1) + ": Wieviele Pins haben Sie diesen Wurf umgeworfen? (0-10)");
                }
                treffer = input.nextInt();
                if (treffer < 0 || treffer > 10) {
                    System.out.println("Bitte geben Sie eine ganze Zahl zwischen 0 und 10 ein.");
                    treffer = input.nextInt();
                }
                pins -= treffer;
                if (pins == 0 && wurf == 0) {
                    multiplyer += 3;
                    wurf++;
                }
                else if (pins == 0 && wurf == 1) {
                    multiplyer = 2;
                }
                punkte += treffer *  multi;
                wurf++;
            }
            if (frames != 10) {
                System.out.println("Punkte: " + punkte);
            }
            frames++;
        }
        System.out.println("------------------------");
        System.out.println(" Erreichte Punkte: " + punkte);
        System.out.println("------------------------");
    }
}
