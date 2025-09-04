package blatt03;

import java.util.Scanner;

public class PQ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie den Wert p ein:");
        double p = input.nextDouble();
        System.out.println("Geben Sie den Wert q ein:");
        double q = input.nextDouble();

        pqFormel(p, q);
    }

    public static void pqFormel(double p, double q) {

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
        }
    }
}