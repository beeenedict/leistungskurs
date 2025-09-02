package blatt03;

import java.util.Scanner;

public class SpringImKreis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben Sie nachenander einen Mittelpunkt m(x|y) und einen Radius r für einen beliebigen Kreis an.");
        System.out.println("Mittelpunkt:");
        double mx = input.nextDouble();
        double my =  input.nextDouble();
        System.out.println("Radius:");
        double r = input.nextDouble();

        System.out.println("Geben Sie nacheinander zwei Koordinaten für den Punkt p(x|y) ein.");
        double px = input.nextDouble();
        double py = input.nextDouble();
        double rp = (px-mx) * (px-mx) + (py-my) * (py-my);

        if (rp < r * r) {
            System.out.printf("Der Punkt p(%.2f|%.2f) befindet sich im Kreis.%n",px,py);
        }
        else if (rp == r * r) {
            System.out.printf("Der Punkt p(%.2f|%f) befindet sich auf dem Kreis.%n",px,py);
        }
        else {
            System.out.printf("Der Punkt p(%.2f|%.2f) befindet sich außerhalb vom Kreis.%n",px,py);
        }
    }
}