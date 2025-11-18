package blatt13;

public class QuadratApproximation {

    /**
     * Gibt den Flächeninhalt eines Quadrats mit der Seitenlänge a zurück
     * @param a int Seitenlänge
     * @return Fläche A
     */

    public static int flaecheQuadrat(int a) {
        return a * a;
    }

    /**
     * Gibt eine Approximation der Seitenlänge seite zur gegebenen Fläche eines Quadrats f
     * @param f int
     * @return double seite
     */

    public static double sucheSeitenlaenge(int f) {
        double l = 1;
        double r = f;
        double seite = (l+r)/2;
        while (Math.abs(f - seite * seite) >= 0.00001) {
            if (seite * seite > f) {
                r = seite;
            }
            else {
                l = seite;
            }
            seite = (l+r)/2;
        }
        return seite;
    }

    /*
    public static void main(String[] args) {
        System.out.println(sucheSeitenlaenge(64));
    }
     */
}
