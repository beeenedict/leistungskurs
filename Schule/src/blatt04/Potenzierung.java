package blatt04;

import java.util.Scanner;

public class Potenzierung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" - Potenzrechner - \n");

        System.out.println("Geben Sie eine beliebige Basis für die Potenz ein."); // Eingabe
        double basis =  input.nextDouble();
        double b = basis; // speichern von Basis / Exponent (+l.18)
        basis = 1;

        System.out.println("Geben Sie eine ganze Zahl für den Exponenten ein.");
        int exponent = input.nextInt();
        int e = exponent;

        while (exponent != 0) { // e-mal multiplizieren bzw. dividieren, wenn e = 0 bleibt basis = 1 da 0^0 = 1

            if (exponent > 0) { // positiber Exponent => multiplizieren mit Basis
                basis *= b;
                exponent--;
            } else { // negativer Exponent => dividieren durch Basis
                basis /= b;
                exponent++;
            }
        }
        System.out.printf("(%.3f)^%d = %.3f", b, e, basis);
    }
}