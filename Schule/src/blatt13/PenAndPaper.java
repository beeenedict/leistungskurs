package blatt13;

public class PenAndPaper {

    public static int wuerfel(int N, int X) {
        int wert = 0;

        for (int i = 1; i < N; i++) {
            wert += Zufall.zufallGanz(1, X);
        }
        return wert;
    }

    public static int wuerfel(int N, int X, int b) {
        return wuerfel(N, X) + b;
    }

    public static boolean check(int difficulty, boolean vor, boolean nach) {
        int t1 = wuerfel(1, 20);

        if ((vor || nach) && !(vor && nach)) {
            int t2 = wuerfel(1, 20);
            if (vor && t2 > t1) {
                t1 = t2;
            }
            if (nach && t2 < t1) {
                t1 = t2;
            }
        }
        if (t1 == 1) {
            System.out.println("Krittischer Fehlschlag!");
            return false;
        }
        if (t1 == 20) {
            System.out.println("Kritischer Erfolg!");
            return true;
        }

        return t1 >= difficulty;
    }

    public static boolean check(int difficulty, boolean vor, boolean nach, int b) {
        int t1 = wuerfel(1, 20);

        if ((vor || nach) && !(vor && nach)) {
            int t2 = wuerfel(1, 20);
            if (vor && t2 > t1) {
                t1 = t2;
            }
            if (nach && t2 < t1) {
                t1 = t2;
            }
        }
        if (t1 == 1) {
            System.out.println("Krittischer Fehlschlag!");
            return false;
        }
        if (t1 == 20) {
            System.out.println("Kritischer Erfolg!");
            return true;
        }

        return t1 + b >= difficulty;
    }

    public static int angriff(int N, int X, int enemyAC, boolean vor, boolean nach, int atkB) {
        boolean treffer = check(enemyAC, vor, nach, atkB);
        if (treffer) {
            return wuerfel(N, X);
        }
        else {
            return -1;
        }
    }

    public static int angriff(int N, int X, int enemyAC, boolean vor, boolean nach, int atkB, int dmgB) {
        boolean treffer = check(enemyAC, vor, nach, atkB);
        if (treffer) {
            return wuerfel(N, X, dmgB);
        }
        else {
            return -1;
        }
    }

    public static void meleeFight(Charakter A, Charakter B) {

    }

    public static void main(String[] args) {
        Charakter Barbar = new Charakter("Barbar", 70, 14, 1, 1, 8, 0, 0, 3);
        Charakter Barde = new Charakter("Barde", 42, 10, 2, 1, 6, 0, 3, 0);
    }
}
