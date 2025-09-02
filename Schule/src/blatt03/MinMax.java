package blatt03;

import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nenne eine ganze Zahl");
        int ersteZahl = input.nextInt();
        System.out.println("Nenne eine weitere ganze Zahl");
        int zweiteZahl = input.nextInt();
        System.out.println("Nenne eine weitere ganze Zahl");
        int dritteZahl = input.nextInt();

        if (ersteZahl >= zweiteZahl && ersteZahl >= dritteZahl) {
            System.out.println(ersteZahl + " ist die größte Zahl");
        }
        else if (zweiteZahl >= ersteZahl && zweiteZahl >= dritteZahl) {
            System.out.println(zweiteZahl + " ist die größte Zahl");
        }
        else {
            System.out.println(dritteZahl + " ist die größte Zahl");
        }
        if (ersteZahl <= zweiteZahl && ersteZahl <= dritteZahl) {
            System.out.println(ersteZahl + " ist die kleinste Zahl");
        }
        else if (zweiteZahl <= ersteZahl && zweiteZahl <= dritteZahl) {
            System.out.println(zweiteZahl + " ist die kleinste Zahl");
        }
        else {
            System.out.println(dritteZahl + " ist die kleinste Zahl");
        }
    }
}
