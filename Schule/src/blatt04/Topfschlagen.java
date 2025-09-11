package blatt04;

import java.util.Random;
import java.util.Scanner;

public class Topfschlagen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int feldGrenze;

        int zuege = 0;

        String error = "Sie können sich nicht außerhalb des Felds bewegen.";

        System.out.println("\nBewegen Sie sich mithilfe von WASD in einem Feld mit von Ihnen ausgewählter Größe auf der Suche nach dem Topf...");
        System.out.println("Geben Sie eine Größe für das Spielfeld ein. Bsp.: 10 -> (-10|-10) bis (10|10)");
        feldGrenze = input.nextInt();
        System.out.println("Möchten Sie den \"Challenge-Modus\" spielen? (Der Topf bewegt sich alle 5 Züge in eine zufällige Richtung) (true/false)");
        boolean challenge = input.nextBoolean();
        int topfMove;
        System.out.println("Das Spiel beginnt! Viel Glück.");

        int topfx = random.nextInt(-feldGrenze, feldGrenze); // zufälliger spawn des topfes im feld
        int topfy = random.nextInt(-feldGrenze, feldGrenze);

        int playerx = random.nextInt(-feldGrenze, feldGrenze); // zufälliger spawn des spielers im feld
        int playery = random.nextInt(-feldGrenze, feldGrenze);

        while (true) {
            char bewegung = input.next().charAt(0);

            if (bewegung == 'a') { // bewegung des spielers falls er dadurch das feld nicht verlässt
                if (playery == -feldGrenze) {
                    System.out.println(error);
                } else {
                    playerx--;
                }
            } else if (bewegung == 'w') {
                if (playerx == feldGrenze) {
                    System.out.println(error);
                } else {
                    playery++;
                }
            } else if (bewegung == 's') {
                if (playerx == -feldGrenze) {
                    System.out.println(error);
                } else {
                    playery--;
                }
            } else if (bewegung == 'd') {
                if (playery == feldGrenze) {
                    System.out.println(error);
                } else {
                    playerx++;
                }
            }

            if (playerx == topfx && playery == topfy) {
                break;
            }
            if (bewegung == 'a' || bewegung == 'd') {
                if ((bewegung == 'a' && playerx >= topfx) || (bewegung == 'd' && playerx <= topfx)) {
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

            /*
            System.out.println("(" + topfx + "|" + topfy + ")" + " " + "(" + playerx + "|" + playery + ")");
             */

            if (challenge) {
                zuege++;
                if (zuege%5 == 0) {
                    topfMove = random.nextInt(1,5);
                    System.out.println(topfMove); //TODO: nur wenn nicht außerhalb feld
                    if (topfMove == 1) {
                        topfy++;
                    }
                    else if (topfMove == 2) {
                        topfx--;
                    }
                    else if (topfMove == 3) {
                        topfy--;
                    }
                    else {
                        topfx++;
                    }
                }

            }
        }
        System.out.println("Sie haben gewonnen!");
    }
}
