package blatt09;

public class Kuerzen {

    /**
     * Überprüft, ob ein Bruch mit natürlichem Nenner und natürlichem Zähler kürzbar ist.
     * @param zaehler int zaehler > 0
     * @param nenner int nenner > 0
     * @return true / false
     */

    public static boolean istKuerzbar(int zaehler, int nenner) {
        int[] teilerArr = Teiler.teiler(zaehler);

        for (int i = 1; i < teilerArr.length; i++) {
            if (Teiler.istTeiler(nenner, teilerArr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gibt den vollständig gekürzten Bruch eines angegebenen Bruchs mit natürlichem Zähler und Nenner aus.
     * @param zaehler int zaehler > 0
     * @param nenner int nenner > 0
     */

    public static void kuerzen(int zaehler, int nenner) {
        int[] teilerArr;

        while (istKuerzbar(zaehler, nenner)) {
            teilerArr = Teiler.teiler(zaehler);

            for (int i = 1; i < teilerArr.length; i++) {
                if (Teiler.istTeiler(nenner, teilerArr[i])) {
                    nenner /= teilerArr[i];
                    zaehler /= teilerArr[i];
                    break;
                }
            }
        }
        System.out.println("Vollständig gekürzter Bruch: " + zaehler + "/" + nenner);
    }

    /*
    public static void main(String[] args) {
        System.out.println(istKuerzbar(9, 18));
        kuerzen(6, 138);
    }
     */
}
