package blatt04;

import java.util.Scanner;

public class Zeitumrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Gebe eine positibe Zahl an Sekunden ein:");
        int sekundenGesamt =  input.nextInt();

        int sekunden = 0;
        int minuten = 0;
        int stunden = 0;
        int tage = 0;

        while (sekundenGesamt > 0) {
            sekunden++;
            if(sekunden == 60) {
                minuten++;
                sekunden = 0;
            }
            if (minuten == 60) {
                stunden++;
                minuten = 0;
            }
            if (stunden == 24) {
                tage++;
                stunden = 0;
            }
            sekundenGesamt--;
        }
        System.out.printf("%d Tage, %d Stunden, %d Minuten, %d Sekunden", tage, stunden, minuten, sekunden);
    }
}

// b) Ich habe nur eine Schleife verwendet, da das Programm so am sinnvollsten schien und es einer normalen Uhr mit dem Umschlagen des Zeigers zur nächsten Minute / Stunde am nächsten kommt.
//    Entsprechend würde dieses Programm im gegebenen Beispiel 8943103 Schleifendurchgänge durchlaufen.

// c) Wenn Initialisieren von Variablen (l. 12-15) nicht als Rechenoperationen zählen, habe auch ich das Problem mit weniger als 10 Rechenoperationen gelöst, entsprechend wäre die Aussage wahr.