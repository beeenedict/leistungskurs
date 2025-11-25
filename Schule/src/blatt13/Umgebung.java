package blatt13;

public class Umgebung {

    /**
     * Findet den benötigten Exponent, zur Potenz Basis b^Exponent <= Grenze g
     * @param b double Basis
     * @param g double Annäherungswert
     * @return int Exponent, -1 -> Fehler (b zu groß / klein)
     */

    public static int findeExponent(double b, double g) {
        if (0 < b && b < 1) {
            int exponent = 1;
            double p = b;
            while (p > g) {
                exponent++;
                p = Math.pow(b, exponent);
            }
            return exponent;
        }
        return -1;
    }

    /*
    public static void main(String[] args) {
        System.out.println(findeExponent(0.5, 0.001));
    }
     */
}
