package blatt03;

import java.util.Scanner;

public class MitOderOhneStrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Wählen Sie eines der Folgenden Gatter: NOT, OR, AND, XOR");
        String gatter = input.nextLine();

        if (gatter.equals("NOT") || gatter.equals("OR") || gatter.equals("AND")  || gatter.equals("XOR")) { // Wenn die Eingabe valide ist

            // Variablen für wiederholt vorkommende prints zur Zeichenminimierung
            String dasGatter = "Das " + gatter + "-Gatter:";
            String anfrage1 = "Befindet sich auf dem ersten Eingang Strom? (true/false)";
            String anfrage2 = "Befindet sich auf dem zweiten Eingang Strom? (true/false)";

            // Zuweisung der jeweiligen prints und Bedingungen zum gewählten Gatter
            if (gatter.equals("NOT")) {
                System.out.printf(dasGatter);
                System.out.println("Das Gatter verfügt über einen Eingang und einen Ausgang.\n");
                System.out.println(anfrage1);
                boolean eingang1 = input.nextBoolean();
                if (eingang1) {
                    System.out.println(eingang1 + " " + gatter + " = false");
                }
                else {
                    System.out.println(eingang1 + " " + gatter + " = true");
                }
            }
            if (gatter.equals("OR")) {
                System.out.println(dasGatter);
                System.out.println("Das Gatter verfügt über zwei Eingänge und einen Ausgang.\n");
                System.out.println(anfrage1);
                boolean eingang1 = input.nextBoolean();
                System.out.println(anfrage2);
                boolean eingang2 = input.nextBoolean();
                if (eingang1 || eingang2) {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = true");
                }
                else {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = false");
                }
            }
            if (gatter.equals("AND")) {
                System.out.println(dasGatter);
                System.out.println("Das Gatter verfügt über einen Eingänge und einen Ausgang.\n");
                System.out.println(anfrage1);
                boolean eingang1 = input.nextBoolean();
                System.out.println(anfrage2);
                boolean eingang2 = input.nextBoolean();
                if (eingang1 && eingang2) {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = true");
                }
                else {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = false");
                }
            }
            if (gatter.equals("XOR")) {
                System.out.println(dasGatter);
                System.out.println("Das Gatter verfügt über zwei Eingänge und einen Ausgang.\n");
                System.out.println(anfrage1);
                boolean eingang1 = input.nextBoolean();
                System.out.println(anfrage2);
                boolean eingang2 = input.nextBoolean();
                if (eingang1 ^ eingang2) {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = true");
                }
                else {
                    System.out.println(eingang1 + " " + gatter + " " + eingang2 + " = false");
                }
            }
        }
        else { // Die Eingabe war falsch bzw. keins der angegebenen Gatter
            System.out.println("Bitte geben Sie eines der angegebenen Gatter an. Achten Sie auf Recht- und Großschreibung");
        }
    }
}