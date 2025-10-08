package blatt09;

//import blatt07.ArbeitMitArrays;

public class Teiler {

    /**
     * Überprüft, ob die Ganzzahl b ein Teiler der Ganzzahl a ist.
     * @param a int a > 0
     * @param b int b > 0
     * @return true / false
     */

    public static boolean istTeiler(int a, int b) {
        return a%b == 0;
    }

    /**
     * Gibt Alle Teiler der Ganzzahl a aus
     * @param a int a > 0
     */

    public static void alleTeiler(int a) {
        System.out.println("Teiler von " + a + " :");

        for (int i = 1; i <= a; i++) {
            if (istTeiler(a, i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Gibt die Anzahl der Teiler der Ganzzahl a zurück.
     * @param a int a > 0
     * @return int Anzahl der Teiler
     */

    public static int anzahlTeiler(int a) {
        int teiler = 0;

        for (int i = 1; i <= a; i++) {
            if (istTeiler(a, i)) {
                teiler++;
            }
        }
        return teiler;
    }

    /**
     *Erstellt einen Array, der alle Teiler einer Ganzzahl a enthält.
     * @param a int a > 0
     * @return int[] Array aller Teiler
     */

    public static int[] teiler(int a) {
        int[] teilerArr = new int[anzahlTeiler(a)];
        int j = 0;

        for (int i = 1; i <= a; i++) {
            if (istTeiler(a, i)) {
                teilerArr[j] = i;
                j++;
            }
        }
        return teilerArr;
    }

    /*
    public static void main(String[] args) {
        System.out.println(istTeiler(1, 1));
        System.out.println(anzahlTeiler(1));
        alleTeiler(1);
        ArbeitMitArrays.printArray(teiler(1));
    }
     */
}
