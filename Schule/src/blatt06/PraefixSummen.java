package blatt06;

import java.util.Random;
import java.util.Scanner;

public class PraefixSummen {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        double[] x = new double[n + 1];
        for (int i = 0; i < x.length; i++) {
            x[i] = rand.nextDouble();
        }

        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }

        double[] schaetz = new double[n];
        for (int i = 0; i < schaetz.length; i++) {
            schaetz[i] = (x[i] + x[i + 1] + x[i + 2] + x[i + 3])/4;
        }

        double[] prae = new double[n];
        prae[0] = 0;
        for (int i = 1; i < prae.length; i++) {
            for (int j = 0; j < i; j++) {
                prae[i] += x[j];
            }
            //prae[i] /= i;
        }
        System.out.println();
        for (int i = 0; i < prae.length; i++) {
            System.out.print(prae[i] + " ");
        }
    }
}
