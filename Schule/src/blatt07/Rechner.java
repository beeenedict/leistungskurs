package blatt07;

import java.util.Scanner;

public class Rechner {

    /**
     * Ausgeben von Summe, Differenz, Produkt, Quotient von zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     */

    public static void operation(double a, double b){
        System.out.println("Summe: " + add(a, b));
        System.out.println("Differenz: " + sub(a, b));
        System.out.println("Produkt: " + mult(a, b));
        System.out.println("Quotient: " + div(a, b));
    }

    /**
     * Errechnen der Summe von zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Summe
     */

    public static double add(double a, double b){
        return a + b;
    }

    /**
     * Errechnen der Differenz von zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Differenz
     */

    public static double sub(double a, double b){
        return a - b;
    }

    /**
     * Errechnen des Produkts von zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Produkt
     */

    public static double mult(double a, double b){
        return a * b;
    }

    /**
     * Errechnen des Quotienten von zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Quotient
     */

    public static double div(double a, double b){
        return a / b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie zwei beliebige Zahlen a und b ein, deren Summe, Differenz, Produkt und Quotient errechnet und Ihnen ausgegeben wird.");
        double a = input.nextDouble();
        double b = input.nextDouble();
        operation(a, b);
    }

}
