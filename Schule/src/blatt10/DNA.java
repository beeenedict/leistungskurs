package blatt10;

import java.util.Arrays;

public class DNA {

    /*

    a)
        Benötigt sind nur vier unterschiedliche Zustände, um identifizieren zu können, um welche Base es sich handelt.
        Im gegebenen Beispiel nutzen wir die Ganzzahlen 0 - 3, entsprechend sind die mit 1 byte möglichen 256 Zustände ausreichend.

     */

    /**
     * Überprüft, ob ein übergebener String dem Schema einer Nukleotidsequenz nach vorgegebenen Regeln entspricht
     * @param nukleotidsequenz String
     * @return boolean
     */

    public static boolean istDNA(String nukleotidsequenz) {
        char[] chars = nukleotidsequenz.toCharArray();
        byte[] arr = new byte[chars.length];

        for (int i = 0; i < chars.length; i++) {

            switch (chars[i]) {
                case '0': case 'A':
                    arr[i] = 0;
                    break;
                case '1': case 'T':
                    arr[i] = 1;
                    break;
                case '2': case 'G':
                    arr[i] = 2;
                    break;
                case '3': case 'C':
                    arr[i] = 3;
                    break;
                default:
                    arr[i] = -1;
            }
        }

        if (arr.length%2 == 0) {
            for (int i = 0; i < arr.length; i+=2) {
                if ((arr[i] == 0 && arr[i+1] != 1) || (arr[i] == 1 && arr[i+1] != 0) || (arr[i] == 2 && arr[i + 1] != 3) || (arr[i] == 3 && arr[i+1] != 2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Wandelt den übergebenen String nach den vorgegebenen Regeln in einen byte-Array um, wenn dieser in korrekter Nukleotidsequenz vorliegt.
     * @param nukleotidsequenz String
     * @return byte[]
     */

    public static byte[] zuDNA(String nukleotidsequenz) {
        if (istDNA(nukleotidsequenz)) {
            char[] chars = nukleotidsequenz.toCharArray();
            byte[] dna = new byte[chars.length];

            for (int i = 0; i < chars.length; i++) {

                switch (chars[i]) {
                    case '0':
                    case 'A':
                        dna[i] = 0;
                        break;
                    case '1':
                    case 'T':
                        dna[i] = 1;
                        break;
                    case '2':
                    case 'G':
                        dna[i] = 2;
                        break;
                    default:
                        dna[i] = 3;
                }
            }
            return dna;
        }
        return null;
    }

    /**
     * Wandelt den übergebenen byte-Array nach den vorgegebenen Regeln in einen String um, wenn dieser in korrekter Nukleotidsequenz vorliegt.
     * @param nukleotidsequenz byte[]
     * @return String
     */

    public static String zuDNA(byte[] nukleotidsequenz) {
        StringBuilder dna = new StringBuilder();

        for (int i = 0; i < nukleotidsequenz.length; i++) {

            switch (nukleotidsequenz[i]) {
                case 0:
                    dna.append('A');
                    break;
                case 1:
                    dna.append('T');
                    break;
                case 2:
                    dna.append('G');
                    break;
                case 3:
                    dna.append("C");
                    break;
                default:
                    dna.append("X");
            }
        }

        if (istDNA(dna.toString())) {
            return dna.toString();
        }
        return null;
    }

    /*

    e)
        String.length * 16 + (byte[]) array.length * 8 + 32 (i)
        (StringBuilder ?)

        8 bit pro Nukleotid

     */

    /**
     * Wandelt den übergebenen String nach den vorgegebenen Regeln in einen boolean-Array um, wenn dieser in korrekter Nukleotidsequenz vorliegt.
     * @param nukleotidsequenz String
     * @return boolean[]
     */

    public static boolean[] zuDNA_Bool(String nukleotidsequenz) {
        if (istDNA(nukleotidsequenz)) {
            char[] chars = nukleotidsequenz.toCharArray();
            boolean[] dna = new boolean[chars.length * 2];

            for (int i = 0; i < chars.length; i ++) {
                switch (chars[i]) {
                    case '0': case 'A':
                        dna[2 * i] = false;
                        dna[2 * i + 1] = false;
                        break;
                    case '1': case 'T':
                        dna[2 * i] = false;
                        dna[2 * i + 1] = true;
                        break;
                    case '2': case 'G':
                        dna[2 * i] = true;
                        dna[2 * i + 1] = false;
                        break;
                    default:
                        dna[2 * i] = true;
                        dna[2 * i + 1] = true;
                }
            }
            return dna;
        }
        return null;
    }

    /**
     * Wandelt den übergebenen boolean-Array nach den vorgegebenen Regeln in einen String um, wenn dieser in korrekter Nukleotidsequenz vorliegt.
     * @param nukleotidsequenz boolean[]
     * @return String
     */

    public static String zuDNA_Bool(boolean[] nukleotidsequenz) {
        StringBuilder dna = new StringBuilder();

        for (int i = 0; i < nukleotidsequenz.length - 1; i += 2) {

            if (!nukleotidsequenz[i] && !nukleotidsequenz[i + 1]) {
                dna.append('A');
            }
            else if (!nukleotidsequenz[i] && nukleotidsequenz[i + 1]) {
                dna.append('T');
            }
            else if (nukleotidsequenz[i] && !nukleotidsequenz[i + 1]) {
                dna.append('G');
            }
            else if (nukleotidsequenz[i] && nukleotidsequenz[i + 1]) {
                dna.append('C');
            }
            else {
                dna.append('X');
            }
        }

        if (istDNA(dna.toString())) {
            return dna.toString();
        }
        return null;
    }

    /*

    h)
        String.length * 16 + (boolean[]) array.length + 32 (i)

        2 bit pro Nukleotid

     */

    /**
     * Wandelt den übergebenen String nach den vorgegebenen Regeln in einen byte-Array um, wenn dieser in korrekter Nukleotidsequenz vorliegt, eine Stelle entsprechen 2 Nukleotidpaaren.
     * @param nukleotidsequenz String
     * @return byte[]
     */

    public static byte[] zuDNA_effizient(String nukleotidsequenz) {

        if (istDNA(nukleotidsequenz) && nukleotidsequenz.length()%4 == 0) {
            byte[] dna = zuDNA(nukleotidsequenz);
            byte[] dnaEffizient = new byte[dna.length / 4];

            for (int i = 0; i < dna.length / 4; i++) {
                dnaEffizient[i] = (byte) (dna[4 * i + 3] + dna[4 * i + 2] * 4 + dna[4 * i + 1] * 16 + dna[4 * i] * 64 - 128);
            }
            return dnaEffizient;
        }
        return null;
    }

    /**
     * Wandelt den übergebenen byte-Array nach den vorgegebenen Regeln in einen String um, wenn dieser in korrekter Nukleotidsequenz (eine stelle entsprciht 2 Nukleotidpaaren) vorliegt.
     * @param nukleotidsequenz byte[]
     * @return String
     */

    public static String zuDNA_effizient(byte[] nukleotidsequenz) {
        StringBuilder dnaStr = new StringBuilder();
        int x;
        int y;
        byte[] dna = new byte[4 * nukleotidsequenz.length];

        for (int i = 0; i < nukleotidsequenz.length; i++) {
            x = nukleotidsequenz[i] + 128;
            y = 128;
            for (int j = 0; j < 8; j++) {
                if (x >= y) {
                    x -= y;
                    dna[4 * i + (int) (j / 2)]++;
                    if (j %2 == 0) {
                        dna[4 * i + (int) (j / 2)]++;
                    }
                }
                y /= 2;
            }
        }

        for (byte b : dna) {
            switch (b) {
                case 0: dnaStr.append("A"); break;
                case 1: dnaStr.append("T"); break;
                case 2: dnaStr.append("G"); break;
                default: dnaStr.append("C"); break;
            }
        }

        if (istDNA(dnaStr.toString())) {
            return dnaStr.toString();
        }
        return null;
    }

    /*

    k)


        2 bit pro Nukleotid

     */

    /*
    public static void main(String[] args) {
        String dna = "TATAGCAT";
        System.out.println(istDNA(dna));
        System.out.println();
        System.out.println(zuDNA(zuDNA(dna)));
        System.out.println(Arrays.toString(zuDNA(dna)));
        System.out.println();
        System.out.println(zuDNA_Bool(zuDNA_Bool(dna)));
        System.out.println(Arrays.toString(zuDNA_Bool(dna)));
        System.out.println();
        System.out.println(zuDNA_effizient(zuDNA_effizient(dna)));
        System.out.println(Arrays.toString(zuDNA_effizient(dna)));
    }
     */
}
