package blatt02;

import java.util.Scanner;

public class Zinssatz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nennen Sie Ihr Startkapital");
        double kapital = input.nextDouble();
        System.out.println("Nenne Sie Ihren Zinssatz in Prozent");
        double zinssatz = input.nextDouble();
        double zinsen = kapital * zinssatz / 100;
        double neuesKapital = kapital + zinsen;

        System.out.printf("Altes Kapital: %.2f €%n", kapital);
        System.out.printf("Zinssatz: %f %% %n%n", zinssatz);
        System.out.printf("Zinsen: %.2f €%n", zinsen);
        System.out.printf("Neues Kapital: %.2f €", neuesKapital); // keine TODOs, da negatives Startkapital (Schulden) möglich sind und auch negative Zinsen zumindest theoretisch möglich sind
    }
}
