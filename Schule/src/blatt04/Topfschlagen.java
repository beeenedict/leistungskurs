package blatt04;

import java.util.Random;
import java.util.Scanner;

public class Topfschlagen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int feldGrenzex = 10;
        int feldGrenzey = 10;

        int topfx = random.nextInt(-feldGrenzex, feldGrenzex);
        int topfy = random.nextInt(-feldGrenzey, feldGrenzey);

        int playerx = random.nextInt(-feldGrenzex, feldGrenzex);
        int playery = random.nextInt(-feldGrenzey, feldGrenzey);

        System.out.println(topfx + " " + topfy + " " + playerx + " " + playery);

        while (true) {
            char bewegung = input.next().charAt(0);

            if (bewegung == 'a') {
                if (playery == -feldGrenzex) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                } else {
                    playerx--;
                }
            } else if (bewegung == 'w') {
                if (playerx == feldGrenzey) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                } else {
                    playery++;
                }
            } else if (bewegung == 's') {
                if (playerx == -feldGrenzey) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                } else {
                    playery--;
                }
            } else if (bewegung == 'd') {
                if (playery == feldGrenzex) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                } else {
                    playerx--;
                }
            }
            if (bewegung == 'a' || bewegung == 'd') {
                if ((bewegung == 'a' && playerx <= topfx) || (bewegung == 'd' && playerx >= topfx)) {
                    System.out.println("wärmer.");
                } else {
                    System.out.println("kälter.");
                }
            }
            if (bewegung == 'w' || bewegung == 's') {
                if ((bewegung == 'w' && playery <= topfy) || (bewegung == 's' && playery >= topfy)) {
                    System.out.println("wärmer.");
                } else {
                    System.out.println("kälter.");
                }
            }
            if (playerx == topfx && playery == topfy) {
                break;
            }
        }
        System.out.println("Sie haben gewonnen!");
    }
}
