package blatt09;

//import blatt07.ArbeitMitArrays;

public class Primzahlen {

    /**
     * Prüft, ob eine natürliche Zahl a eine Primzahl ist.
     * @param a int a > 0
     * @return true / false
     */

    public static boolean istPrim(int a) {
        return Teiler.anzahlTeiler(a) == 2;
    }

    /**
     * Gibt alle Primzahlen aus, die größer oder gleich einer natürlichen Grenze sind.
     * @param grenze int grenze > 0
     */

    public static void printPrim(int grenze) {
        for (int i = 2; i < grenze; i++) {
            if (istPrim(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Gibt einen int Array mit Länge n zurück, der die ersten n Primzahlen enthält.
     * @param n int > 0
     * @return int[] erste n Primzahlen
     */

    public static int[] generierePrimzahlen(int n) {
        int[] primzahlen = new int[n];
        n = 0;
        int i = 0;

        while (n < primzahlen.length) {
            if (istPrim(i)) {
                primzahlen[n] = i;
                n++;
            }
            i++;
        }

        return primzahlen;
    }

    /**
     * Bestimmt die Primfaktorzerlegung einer natürlichen Zahl und gibt diese aus.
     * @param a int a > 1
     */

    public static void primfaktorzerlegung(int a) {
        int[] teilerArr;

        System.out.print(a + " = ");
        while (!istPrim(a)) {
            teilerArr = Teiler.teiler(a);
            for (int i = 1; i < teilerArr.length; i++) {
                if (istPrim(teilerArr[i])) {
                    System.out.print(teilerArr[i] + " * ");
                    a /= teilerArr[i];
                    break;
                }
            }
        }
        System.out.print(a);
    }

    /*
    public static void main(String[] args) {
        System.out.println(istPrim(11223));
        ArbeitMitArrays.printArray(generierePrimzahlen(1));
        primfaktorzerlegung(11);
    }
     */
}
