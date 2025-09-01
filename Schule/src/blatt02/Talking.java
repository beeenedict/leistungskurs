package blatt02;

import java.util.Scanner;

public class Talking {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); //Es wird eine neue Input Variable erstellt.
        System.out.println("Guten Tag, wie heißen Sie?"); //Der Nutzer wird gefragt, sodass ihm der gesuchte Inhalt des Inputs klar wird.
        String name = input.nextLine(); //Der Nutzer bekommt die Möglichkeit, einen Input zu tätigen.
        System.out.println("Hallo " + name + "!"); //Das Programm nutzt den Input, und Verwendet ihn um den Nutzer zu grüßen
    }
}
