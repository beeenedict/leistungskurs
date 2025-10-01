package blatt08;

public class Palindrom {

    /**
     * Umdrehen eines Stings
     * @param s String
     * @return der umgedrehte String
     */

    public static String umdrehen(String s){
        char[] sArr = s.toCharArray();
        char[] umg = new char[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            umg[i] = sArr[sArr.length - 1 - i];
        }
        return new String(umg);
    }

    /**
     * Prüft, ob ein gegebener String ein Palindrom ist.
     * @param s String
     * @return ist ein Palindrom / ist kein Palindorm -> true / false
     */

    public static boolean istPalindrom(String s){
        return s.toLowerCase().equals(umdrehen(s.toLowerCase()));
    }
}
