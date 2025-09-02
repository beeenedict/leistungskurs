package blatt03;

import java.util.Scanner;

public class test {
    static public void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            double antwort = sc.nextDouble();
            antwort = (((int) antwort) + 2) / 3;
            System.out.println(antwort);
        }
    }
}
