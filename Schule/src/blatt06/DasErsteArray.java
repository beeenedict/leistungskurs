package blatt06;

public class DasErsteArray {
    public static void main(String[] args) {
        int[] array = new int[990];

        for (int i = 0; i < array.length; i++) {
            array[i] = 10 + i;
        }

        System.out.println("Ausgabe vorwärts:");

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println("\nAusgabe rückwerts:");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
