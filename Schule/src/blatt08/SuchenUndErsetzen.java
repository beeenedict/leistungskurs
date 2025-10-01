package blatt08;

public class SuchenUndErsetzen {

    /**
     * Alle Characters "gesucht" in String s werden durch "ersatz" ersetzt
     * @param s String
     * @param gesucht char, der ersetzt werden soll
     * @param ersatz char, der "gesucht" ersetzen soll
     * @return String mit ersetzten Characters
     */

    public static String ersetzen(String s, char gesucht, char ersatz) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == gesucht) {
                chars[i] = ersatz;
            }
        }
        return new String(chars);
    }
}
