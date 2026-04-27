package blatt18;

public class TuermeVonHanoi {

    static String S1 = "";
    static String S2 = "";
    static String S3 = "";

    public static void initStaebe(int n) {
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                S1 = i + S1;
            }
            S2 = "";
            S3 = "";
        }
    }

    public static void printStaebe() {
        System.out.println("Stab 1: " + S1 + "\nStab 2: " + S2 + "\nStab 3: " + S3);
    }

    public static void removeScheibe(int i) {
        if (i == 1) {
            S1 = S1.substring(0, S1.length() - 1);
        }
        else if (i == 2) {
            S2 = S2.substring(0, S2.length() - 1);
        }
        else if (i == 3) {
            S3 = S3.substring(0, S3.length() - 1);
        }
    }

    public static void addScheibe(int i, String s) {
        if (i == 1) {
            S1 = S1 + s;
        }
        else if (i == 2) {
            S2 = S2 + s;
        }
        else if (i == 3) {
            S3 = S3 + s;
        }
    }

    public static String getStab(int i) {
        if (i == 1) {
            return S1;
        }
        else if (i == 2) {
            return S2;
        }
        else if (i == 3) {
            return S3;
        }
        return null;
    }

    public static boolean platziereScheibe(int start, int ziel) {
        if (!(start > 3 || start < 1 || ziel > 3 || ziel < 1)) {
            String startS = getStab(start);
            String zielS = getStab(ziel);

            assert startS != null;
            if (!startS.isEmpty()) {
                String s1 = startS.substring(startS.length()-1);
                int a = Integer.parseInt(s1);

                assert zielS != null;
                if (!zielS.isEmpty()) {
                    String s2 = zielS.substring(zielS.length()-1);
                    int b = Integer.parseInt(s2);

                    if (a > b) {
                        return false;
                    }
                }

                removeScheibe(start);
                addScheibe(ziel,s1);

                System.out.println("S" + start + " nach " + "S" +ziel);
                printStaebe();
                return true;
            }
        }
        return false;
    }

    public static int getRest(int start, int ende) {
        int rest = 0;

        if (start == 1 && ende == 2) {
            rest = 3;
        } else if (start == 1 && ende == 3) {
            rest = 2;
        } else if (start == 2 && ende == 3) {
            rest = 1;
        } else if (start == 2 && ende == 1) {
            rest = 3;
        } else if (start == 3 && ende == 1) {
            rest = 2;
        } else if (start == 3 && ende == 2) {
            rest = 1;
        }

        return rest;
    }

    public static void platziereTurm(int start, int ziel, int groesse) {
        if (groesse != 0) {
            int rest = getRest(start, ziel);

            platziereTurm(start, rest, groesse-1);
            platziereScheibe(start, ziel);
            platziereTurm(rest, ziel, groesse-1);
        }

    }

    public static void main(String[] args) {
        initStaebe(4);
        printStaebe();
        platziereTurm(1,3,4);
    }
}
