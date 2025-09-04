package blatt03;

import java.util.Scanner;

public class PQAllgemein{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie den Wert a ein:");
        double a = input.nextDouble();
        System.out.println("Geben Sie den Wert b ein:");
        double b = input.nextDouble();
        System.out.println("Geben Sie den Wert c ein:");
        double c = input.nextDouble();
        System.out.println("Geben Sie den Wert d ein:");
        double d = input.nextDouble();

        double p = b/a; // Umformung der allgemeinen Form in die pq-Formel-Form
        double q = (c-d)/a;

        //Verwendung der Funktion pqFormel aus class blatt03.PQ mit Parametern p, q um Wiederholung zu vermeiden.
        //  -> Funktionieren class-übergreifende Funktionen in der Abgabe über die Website?
        //  -> sonst l. 24 statt l. 26 - 42 auskommentieren

        PQ.pqFormel(p, q);

        /*
        double sqrt = Math.sqrt((p/2) * (p/2) - q); // Aufteilung des Terms in den Teil unter der Wurzel und den Rest, um seperat prüfen zu können, ob die Wurzel und somit die Funktion eine Lösung hat.
        double x1 = -(p/2) + sqrt;
        double x2 = -(p/2) - sqrt;

        if (sqrt >= 0) { // Jede reelle Zahl die das Ergebnis einer Wurzel ist, ist nichtnegativ, also >= 0
            if (x1 == x2) { //Beide Lösungen sind gleich, d.h. es gibt nur eine.
                System.out.printf("Die Funktion besitzt nur eine Lösung:%n\tx ~= %.2f", x1);
            }
            else { // Wenn es Lösungen, aber nicht nur eine, gibt, sind diese x1 und x2
                System.out.printf("Die Funktion besitzt zwei Lösungen:%n\tx1 ~= %.2f%n\tx2 ~= %.2f", x1, x2);
            }
        }
        else { // Der Wert unter der Wurzel war negativ, womit die Wurzel kein Ergebnis und die Funktion keine Lösung hat.
            System.out.println("Die Funktion besitzt keine Lösung.");

         */

        }
    }