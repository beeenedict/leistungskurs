package blatt04;

import java.util.Random;
import java.util.Scanner;

public class Topfschlagen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int topfx = random.nextInt(-100, 100);
        int topfy = random.nextInt(-100, 100);

        int playerx = random.nextInt(-100, 100);
        int playery = random.nextInt(-100, 100);

        System.out.println(topfx + " " + topfy + " " + playerx  + " " + playery);

        while (true) {
            char bewegung = input.next().charAt(0);

            if (bewegung == 'a') {
                if (playery == -100) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                }
                else {
                    playerx--;
                }
            } else if (bewegung == 'w') {
                if (playerx == 100) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                }
                else {
                    playery++;
                }
            } else if (bewegung == 's') {
                if (playerx == -100) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                }
                else {
                    playery--;
                }
            } else if (bewegung == 'd') {
                if (playery == 100) {
                    System.out.println("Sie können sich nicht außerhalb des Felds bewegen.");
                }
                else {
                    playerx--;
                }
            }
            if (bewegung == 'a' ||  bewegung == 'd') {
                if ((bewegung == 'a' && playery < topfy) || (bewegung == 'd' && playery > topfy)) {
                    System.out.println("wärmer.");
                }
                else {
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
