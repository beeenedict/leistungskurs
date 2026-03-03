package blatt18;

import blatt14.MultiArrays;

public class TuermeVonHanoi {

    static int[] stab1;
    static int[] stab2;
    static int[] stab3;

    static int[] turm;

    static int z = 0;

    public static void initStaebe(int n) {
        stab1 = new int[n];
        stab2 = new int[n];
        stab3 = new int[n];
        turm = new int[n];

        for (int i = 0; i < n; i++) {
            turm[i] = i + 1;
            stab1[i] = i + 1;
            stab2[i] = 0;
            stab3[i] = 0;
        }
    }

    public static void turmUmbau() {
        if (stab3 == turm || z > 6) {
            printTuerme();
        }
        else {
            int erster1 = stab1.length - 1;
            int erster2 = stab2.length - 1;
            int erster3 = stab3.length - 1;
            for (int i = 0; i < stab1.length; i++) {
                if (stab1[i] != 0) {
                    erster1 = i;
                    break;
                }
                if (stab2[i] != 0) {
                    erster2 = i;
                    break;
                }
                if (stab3[i] != 0) {
                    erster3 = i;
                    break;
                }
            }

            if ((stab3[erster3] == 0) || (stab1[erster1] <  stab3[erster3])) {
                if (stab3[erster3] != 0) {
                    stab3[erster3 - 1] = stab1[erster1];
                } else {
                    stab3[erster3] = stab1[erster1];
                }
                stab1[erster1] = 0;
            }
            else if ((stab2[erster2] == 0) || (stab1[erster1] <  stab2[erster2])) {
                if (stab2[erster2] != 0) {
                    stab2[erster2 - 1] = stab1[erster1];
                } else {
                    stab2[erster2] = stab1[erster1];
                }
                stab1[erster1] = 0;
            }
            else if ((stab2[erster2] == 0) || stab3[erster3] <  stab2[erster2]) {
                if (stab2[erster2] != 0) {
                    stab2[erster2 - 1] = stab3[erster3];
                } else {
                    stab2[erster2] = stab3[erster3];
                }
                stab3[erster3] = 0;
            }
            else if ((stab3[erster3] == 0) || stab2[erster2] < stab3[erster3]) {
                if (stab3[erster3] != 0) {
                    stab3[erster3 - 1] = stab2[erster2];
                } else {
                    stab3[erster3] = stab2[erster2];
                }
                stab2[erster2] = 0;
            }

            z++;
            turmUmbau();
        }
    }

    public static void printTuerme() {
        for (int i = 0; i < stab1.length; i++) {
            System.out.println(stab1[i] + "\t\t\t" + stab2[i] + "\t\t\t" + stab3[i]);
        }
    }

    public static void main(String[] args) {
        initStaebe(17);
        turmUmbau();
        printTuerme();
    }
}
