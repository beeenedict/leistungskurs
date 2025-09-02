package blatt03;

import java.util.Scanner;

public class Notenrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int note = 1;

        System.out.println("Wieviele Punkte waren in der schriftlichen Überprüfung maximal zu erreichen?"); // Angabe maximaler und erreichter Punktzahl
        int maximalePunkte = input.nextInt();
        System.out.println("Wie viele Punkte haben Sie erreicht?");
        double erreichtePunkte = input.nextDouble();

        if (maximalePunkte == 15) { // MSS-Noten passen prozentual nicht in das Schema der MSS-Benotung, weshalb diese seperat zugewiesen bzw. angepasst werden, damit die note dennoch stimmt.
            System.out.println("Handelt es sich bei der Überprüfung um eine Kursarbeit bzw. wird sie nach MSS-Schema bewertet(15 = 1+, 14 = 1, 13 = 1-...)? (j/n)");
            char antwort = input.next().charAt(0);
            if (antwort == 'j' || antwort == 'J' ||  antwort == 'y' || antwort == 'Y') {
                if (erreichtePunkte >= 15) { // einzelne Abfrage nach voller Punltzahl da 13, 14, 15 gleichgestellt werden
                    System.out.println("Herzlichen Glückwunsch, Sie haben die volle Punktzahl erreicht und ein Amiibo gewonnen (nein, haben Sie nicht)");
                }
                maximalePunkte = 100;
                erreichtePunkte = 20 * (int) ((erreichtePunkte + 2)/3) -1; // Umformung der MSS-Noten in Prozente die dem Schema gerecht werden, -1 damit 13 nicht 100%
            }
        }

        if (erreichtePunkte < 0 || maximalePunkte <= 0) { // Es können keine negativen Maximalpunkte oder negative erreichte Punktzahlen angegeben werden
            System.out.println("Bitte geben Sie für die erreichte Punktzahl einen nichtnegativen und für die maximale Punktzahl einen positiben Wert.");
            System.exit(0);
        }
        if (erreichtePunkte >= maximalePunkte) { // Überprüfung: Maximalpunktzahl erreicht?
            System.out.println("Herzlichen Glückwunsch, Sie haben die volle Punktzahl erreicht und ein Amiibo gewonnen (nein, haben Sie nicht)");
        }
        if (erreichtePunkte / maximalePunkte >= 0.85) { // Vergleich des Anteils der erreichten Punktzahl mit der Maximalpunktzahl + Zuweisung nach Tabelle
            System.out.println("Note: " + note);
        }
        else if (erreichtePunkte / maximalePunkte >= 0.7) {
            note = 2;
            System.out.println("Note: " + note);
        }
        else if (erreichtePunkte / maximalePunkte >= 0.55) {
            note = 3;
            System.out.println("Note: " + note);
        }
        else if (erreichtePunkte / maximalePunkte >= 0.39) {
            note = 4;
            System.out.println("Note: " + note);
        }
        else if (erreichtePunkte / maximalePunkte >= 0.17) {
            note = 5;
            System.out.println("Note: " + note);
        }
        else {
            note = 6;
            System.out.println("Note: " + note);
        }

    }
}
