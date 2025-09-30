package blatt07;

import java.util.Scanner;

public class ArbeitMitArrays {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(" " + array[i] + " ");
            if (i == array.length - 1) {
                System.out.println("]");
            }
            else {
                System.out.print("|");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[]{1, 2, 3, 4, 5};
        printArray(a);
    }

}
