package blatt08;

public class Klammernsprache {

    /**
     * Prüft, ob alle Klammern '(' oder ')' zusammen ein Klammerwort ergeben
     * @param s String
     * @return enthält der gegebene String ein Klammerwort
     */

    public static boolean istKlammerwort(String s){
        int offen = 0;
        char[] klammern = s.toCharArray();
        for (int i = 0; i < klammern.length; i++) {
            if (offen < 0) {
                return false;
            }
            if (klammern[i] == '(') {
                offen++;
            }
            else if (klammern[i] == ')') {
                offen--;
            }
        }
        return offen == 0;
    }
}
