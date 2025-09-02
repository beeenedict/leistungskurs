package blatt03;

import java.util.Scanner;

public class SpringImKreis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie nacheinander zwei Koordinaten für den Punkt p(x|y) ein.");
        double x = input.nextDouble();
        double y = input.nextDouble();

        if (x * x + y * y < 1) {
            System.out.println("Der Punkt p(" + x + "|" + y + ") befindet sich im Einheitskreis.");
        }
        else if (x * x +  y * y == 1) {
            System.out.println("Der Punkt p(" + x + "|" + y + ") befindet sich auf dem Einheitskreis.");
        }
        else {
            System.out.println("Der Punkt p(" + x + "|" + y + ") befindet sich außerhalb vom Einheitskreis.");
        }
    }
}
