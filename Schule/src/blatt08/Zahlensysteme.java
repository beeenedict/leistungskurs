package blatt08;

public class Zahlensysteme {

    /**
     * Überprüft, ob der gegebene String eine Dezimalzahl in korrekter schreibweise ist. -> ziffern 0-9
     * @param s String
     * @return true / false
     */

    public static boolean istDezimal(String s){
        char[] ziffern = s.toCharArray();

        if (ziffern[0] == '0') {
            return false;
        }
        for (int i = 0; i < ziffern.length; i++) {
            if (ziffern[i] < '0' || ziffern[i] > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Überprüft, ob der gegebene String eine Binärzahl in korrekter schreibweise ist. -> in Klammern mit Basis 2, nur 0 oder 1
     * @param s String
     * @return true / false
     */

    public static boolean istBinaer(String s){
        char[] ziffern = s.toCharArray();
        if (ziffern[0] != '(' || ziffern[ziffern.length - 2] != ')' || ziffern[ziffern.length - 1] != '2') {
            return false;
        }
        for (int i = 1; i < ziffern.length - 2; i++) {
            if (ziffern[i] != '1' && ziffern[i] != '0') {
                return false;
            }
        }
        return true;
    }

    /**
     * Überprüft, ob der gegebene String eine Hexadezimalzahl in korrekter schreibweise ist. -> in Klammern mit Basis 16, nur 0-9 oder A-F / a-f
     * @param s String
     * @return true / false
     */

    public static boolean istHexadezimal(String s){
        char[] ziffern = s.toUpperCase().toCharArray();

        if (ziffern[0] != '(' || ziffern[ziffern.length - 3] != ')' || ziffern[ziffern.length - 2] != '1' || ziffern[ziffern.length - 1] != '6') {
            return false;
        }
        for (int i = 1; i < ziffern.length - 3; i++) {
            if ((ziffern[i] < '0' && ziffern[i] > '9') || (ziffern[i] < 'A' && ziffern[i] > 'F')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Wandelt einen String in eine Dezimalzahl (int) um, wenn dieser in einer der folgenden Systeme vorliegt: Binär, Hexadezimal, Dezimal, überprüft durch die Funktionen istDezimal(s), istBinaer(s), istHexadezimal(s), entsprechende Form / Schreibweise ist notwendig.
     * @param s String
     * @return int
     */

    public static int zuDezimal(String s){
        int dezimal = 0;
        if (istDezimal(s)) {
            dezimal = Integer.parseInt(s);
        }

        if (istBinaer(s)) {
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length - 2; i++) {
                if (chars[i] == '1') {
                    dezimal += (int) Math.pow(2, chars.length - i - 3);
                }
            }
        }

        if (istHexadezimal(s)) {
            char[] chars = s.toUpperCase().toCharArray();
            int ziffer = 0;

            for (int i = 1; i < chars.length - 3; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    ziffer = chars[i] - '0';
                }
                else if (chars[i] >= 'A' && chars[i] <= 'F') {
                    ziffer = chars[i] - 'A' + 10;
                }
                dezimal += ziffer * (int) Math.pow(16, chars.length - i - 4);
            }
        }
        return dezimal;
    }

    public static void main(String[] args) {
        // --test / überprüfung--
        String dezimalzahl = "3405";
        System.out.println(istDezimal(dezimalzahl));
        System.out.println(istBinaer(dezimalzahl));
        System.out.println(istHexadezimal(dezimalzahl));

        System.out.println();

        String binaerzahl = "(100101)2";
        System.out.println(istDezimal(binaerzahl));
        System.out.println(istBinaer(binaerzahl));
        System.out.println(istHexadezimal(binaerzahl));

        System.out.println();

        String hexadezimalzahl = "(1a2e)16";
        System.out.println(istDezimal(hexadezimalzahl));
        System.out.println(istBinaer(hexadezimalzahl));
        System.out.println(istHexadezimal(hexadezimalzahl));

        System.out.println();

        System.out.println(zuDezimal(dezimalzahl));
        System.out.println(zuDezimal(binaerzahl));
        System.out.println(zuDezimal(hexadezimalzahl));
    }

}
