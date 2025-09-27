package blatt06;

// finale Abgabe

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie an, wieviele der ersten Zahlen der Fibonacci-Reihe Ihnen ausgegeben werden sollen.");
        int n = input.nextInt();
        double[] fibonacci = new double[n];
        if (fibonacci.length > 0) {
            fibonacci[0] = 0;
        }
        if (fibonacci.length > 1) {
            fibonacci[1] = 1;
        }
        for (int i = 0; i < fibonacci.length - 2; i++) {
            fibonacci[i + 2] = fibonacci[i] + fibonacci[i + 1];
        }

        for (int i = 0; i < fibonacci.length; i++) {
            System.out.printf("%.0f%n", fibonacci[i]);
        }

        if (fibonacci.length > 2) { // length = 2 -> dividieren durch 0
            double quotient = fibonacci[n - 1] / fibonacci[n - 2];
            System.out.println("\n" + fibonacci[n-1] + " / " + fibonacci[n-2] + " = " + quotient);
        }

        // c) Der in b) errechnete Quotien nähert sich dem goldenen Schnitt p(phi) = (1 + 5^1/2) / 2 ~= 1,6180339887
    }
}
