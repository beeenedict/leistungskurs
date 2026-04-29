package blatt19;

public class GGT {

    /**
     * Berechnet rekursiv den größten gemeinsamen Teiler von m und n
     * @param m int
     * @param n int
     * @return int ggT
     */

    public static int ggT(int m, int n) {
        if(m == n) return m;
        else if (m > n) return ggT(m - n, n);
        else return ggT(m, n - m);
    }

    public static void main(String[] args) {
        System.out.println(ggT(472, 228));
    }
}
