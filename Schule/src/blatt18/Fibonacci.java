package blatt18;

public class Fibonacci {

    /**
     * Berechnet rekursiv die n. Fibonacci-Zahl
     * @param n int > 0
     * @return int
     */

    public static int fibonacci(int n) {
        if (n < 0) return 0;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
