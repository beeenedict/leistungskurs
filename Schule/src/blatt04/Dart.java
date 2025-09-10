package blatt04;

import java.util.Scanner;
/*
|-----------------------------------------------------------------------------------|
Aufgabe:
Du kennst sicherlich die Sportart Dart. Falls nicht ist das gar kein Problem,
denn hier sind die nochmal die Regeln (verkürtzt):
1. Ein Dartspiel beginnt bei 501 Punkten.
2. Ein Spieler kann in jeder Runde eine Punktzahl zwischen 0-180.
3. Die geworfenen Punkte werden in jeder Runde von der Gesamtpunktzahl abgezogen.
4. Das Spiel endet, wenn man exakt 0 Punkte erreicht. Sollte man ins negative geraten,
wird man auf den Wert von der vorherigen Runde zurückgesetzt.

Implementiere nun einen automatischen Dartzähler, damit der Spieler seine Punkte nicht
selbst im Kopf rechnen muss.
 |-----------------------------------------------------------------------------------|
 */
public class Dart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Erzeuge Scanner

        int punkte = 501; //Variable "punkte" mit 501 initialisiert -->Startwert
        int wuerfe = 0;
        int wurf = 0;

        while (true) {
            while (wuerfe < 3) {
                System.out.println("Geben Sie die Punktzahl Ihres " + (wuerfe + 1) + ". Wurfes ein (0-60)");
                wurf += scanner.nextInt();
                wuerfe += 1;
            }
            wuerfe = 0;

            System.out.println("Sie haben in dieser Runde " + wurf + " Punkte erzielt");

            punkte -= wurf;

            if (punkte == 0) {
                break;
            }
            else if (punkte < 0) {
                punkte += wurf;
            }
            System.out.println("Verbleibende Punkte: " + punkte);
            wurf = 0;
        }
        System.out.println("Sie haben Gewonnen!");
    }
}
