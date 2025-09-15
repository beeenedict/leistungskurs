package blatt04;

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

        while (frames < 10) {
            System.out.println("-- Frame " + (frames + 1) + " --\n");
            pins = 10;
            wurf = 0;
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
                System.out.println("Wurf " + (wurf + 1) + ": Wieviele Pins haben Sie diesen Wurf umgeworfen? (0-10)");
                treffer = input.nextInt();
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
            System.out.println("Punkte: " + punkte);
            frames++;
        }
    }
}
