package blatt05;

import java.util.Scanner;

public class PasswortGruppeB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean kleinB = false;
        boolean grossB = false;
        boolean sonderZ = false;
        boolean laenge = false;
        String passwortB;

        System.out.println("Geben Sie ihr Passwort ein:");
        String passwort = input.nextLine();

        while (true) {
            int len = passwort.length();
            if (len > 8) {
                laenge = true;
            }
            int i = len;
            while (i > 0) {
                char p = passwort.charAt(i - 1);
                if (p >= 'a' && p <= 'z') {
                    kleinB = true;
                }
                else if (p >= 'A' && p <= 'Z') {
                    grossB = true;
                }
                else {
                    sonderZ = true;
                }
                i--;
            }
            if (laenge && grossB && kleinB && sonderZ) {
                break;
            }
            else {
                System.out.println("Ihr Passwort muss folgende Kriterien erfüllen:");
                if (!laenge) {
                    System.out.println("\tIhr Passwort muss aus mehr als 8 Zeichen bestehen");
                }
                if (!kleinB) {
                    System.out.println("\tEs muss mindestens ein Kleinbuchstabe enthalten sein.");
                }
                if (!grossB) {
                    System.out.println("\tEs muss mindestens ein Großbuchstabe enthalten sein.");
                }
                if (!sonderZ) {
                    System.out.println("\tEs muss mindestens ein Sonderzeichen oder eine Zahl enthalten sein.");
                }
                System.out.println("\nBitte geben Sie ein Passwort an, das alle der genannten Kriterien erfüllt.");

                passwort = input.nextLine();
            }
        }

        System.out.println("Passwort angenommen.\n");
        System.out.println("Bitte bestätigen Sie Ihr Passwort:");
        passwortB = input.nextLine();

        while (!passwort.equals(passwortB)) {
            System.out.println("Das angegebene Passwort stimmt nicht überein.\nBitte versuchen Sie es erneut.");
            passwortB = input.nextLine();
        }
        System.out.println("Passwort erfolgreich registriert.");
    }
}