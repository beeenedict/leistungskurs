package blatt06;

import java.util.Arrays;
import java.util.Scanner;

public class GrenzenSetzen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie eine ganzzahlige Untergrenze ein:");
        int u = input.nextInt();

        System.out.println("Geben Sie eine ganzzahlige Obergrenze ein:");
        int o = input.nextInt();

        while (u >= o) {
            System.out.println("Bitte geben Sie eine Untergrenze ein:");
            u = input.nextInt();
            System.out.println("Bitte geben Sie eine Obergrenze ein, die größer ist als die angegebene Untergrenze");
            o = input.nextInt();
        }

        int[] zahlen = new int[o - u + 1];

        for (int i = 0; i < zahlen.length; i++) {
            zahlen[i] = u + i;
        }

        System.out.println("Zahlen von " + u + " bis " + o + ":");

        for (int i = 0; i < zahlen.length; i++) {
            System.out.println(zahlen[i]);
        }
    }
}