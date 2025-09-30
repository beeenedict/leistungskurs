package blatt07;

import java.util.Scanner;

public class Stein {

    /**
     * Ermittelt den größten gemeinsamen Teiler von den Ganzzahlen a und b
     * @param a int
     * @param b int
     * @return GGT von a und b
     */

    public static int steinGGT(int a, int b) {
        int k = 0;
        while (a != 0 && b != 0) {
            if (a%2 == 0 && b%2 == 0) {
                a /= 2;
                b /= 2;
                k++;
            }
            else if (a%2 == 0) {
                a /= 2;
            }
            else if (b%2 == 0) {
                b /= 2;
            }
            else {
                if (a > b) {
                    a = (a - b) / 2;
                }
                else {
                    b = (b - a) / 2;
                }
            }
        }
        int c;
        if(a == 0) {
            c = b;
        }
        else {
            c = a;
        }
        return c * (int) Math.pow(2, k);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie zwei Ganzzahlen ein, dessen größter gemeinsamer Teiler ermittelt werden soll.");
        int a =  input.nextInt();
        int b = input.nextInt();

        System.out.println("Größter gemeinsamer Teiler: " + steinGGT(a, b));
    }
}
