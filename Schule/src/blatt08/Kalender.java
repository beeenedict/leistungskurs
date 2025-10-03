package blatt08;

public class Kalender {

    /**
     * Extrahiert den Tag aus einem String, der ein Datum in europäischem Format:
     * @param date String "TT.MM.JJJJ"
     * @return int tag
     */

    public static int getTag(String date) {
        char[] chars = date.toCharArray();
        return 10 * (chars[0] - '0') + chars[1] - '0';
    }

    /**
     * Extrahiert den Monat aus einem String, der ein Datum in europäischem Format:
     * @param date String "TT.MM.JJJJ"
     * @return int Monat
     */

    public static int getMonat(String date) {
        char[] chars = date.toCharArray();
        return 10 * (chars[3] - '0') + chars[4] - '0';
    }

    /**
     * Extrahiert den Jahr aus einem String, der ein Datum in europäischem Format:
     * @param date String "TT.MM.JJJJ"
     * @return int Jahr
     */

    public static int getJahr(String date) {
        char[] chars = date.toCharArray();
        return 1000 * (chars[6] - '0') + 100 * (chars[7] - '0') + 10 * (chars[8] - '0') + (chars[9] - '0');
    }

    /**
     * Prüft, ob ein gegebenes Jahr ein Schaltjahr ist.
     * @param jahr Jahr
     * @return true / false
     */

    public static boolean istSchaltjahr(int jahr) {
        return jahr % 400 == 0 || (jahr % 4 == 0 && jahr % 100 != 0);
    }

    /**
     * Wandelt die gegebenen Ganzzahlen Tag, Monat und Jahr in ein Datum in europäischem Format um.
     * @param tag Tag
     * @param monat Monat
     * @param jahr Jahr
     * @return String "TT.MM.JJJJ"
     */

    public static String zuDatum(int tag, int monat, int jahr) {
        String a = "";
        String b = "";
        StringBuilder c = new StringBuilder();

        if (tag < 10) {
            a = "0";
        }
        if (monat < 10) {
            b = "0";
        }
        for (int i = jahr; i < 1000; i *= 10) {
            c.append("0");
        }

        return a + tag + "." + b + monat + "." + c + jahr;
    }

    /**
     * Errechnet das Datum des auf ein gegebenes Datum folgenden Tages.
     * @param date gegebenes Datum
     * @return Datum des Folgetages String "TT.MM.JJJJ"
     */

    public static String naechsterTag(String date) {
        int tag = getTag(date) + 1;
        int monat = getMonat(date);
        int jahr = getJahr(date);
        boolean monatsende = false;

        if (monat != 2) {
            if (monat%2 == 0 && tag == 31) {
                monatsende = true;
            }
            else if (tag == 32) {
                monatsende = true;
            }
        }
        else if (istSchaltjahr(jahr) && tag == 30) {
            monatsende = true;
        }
        else if (!istSchaltjahr(jahr) && tag == 29) {
            monatsende = true;
        }

        if (monatsende) {
            monat++;
            tag = 1;
        }

        if (monat == 13) {
            jahr++;
            monat = 1;
        }

        return zuDatum(tag, monat, jahr);
    }

    /*
    public static void main(String[] args) { // test
        String aaa = "31.06.2008";
        System.out.println(naechsterTag(aaa));
    }

     */
}