package blatt18;

public class Summe {

    /**
     * Berechnet rekursiv die Gaußsche Summe der natürlichen Zahl n,
     * @param n int
     * @return int Summe
     */

    public static int summe(int n) {
        if (n <= 0) return 0;

        else {
            return n + summe(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(summe(6));
    }
}
