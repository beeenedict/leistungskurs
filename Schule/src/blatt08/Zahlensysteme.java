package blatt08;

public class Zahlensysteme { // TODO: Dokumentieren Prozeduren

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

    public static String zuBinaer(String s){ // TODO: dezimal zu binär (Stringschreibweise, ()2), toUpperCase
        return "aaaaaaaaaaaaaaa";
    }

    public static int zuDezimal(String s){
        int dezimal = 0;
        if (istDezimal(s)) {
            return Integer.parseInt(s);
        }
        if (istBinaer(s)) {
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length - 2; i++) {
                if (chars[i] == '1') {
                    dezimal += Math.pow(2, chars.length - i - 3);
                }
            }
        }

        if (istHexadezimal(s)) {
            s = zuBinaer(s);
            zuDezimal(s);
        }

        return dezimal;
    }

    public static void main(String[] args) {
        System.out.println(zuDezimal("(100)2"));
    }
}
