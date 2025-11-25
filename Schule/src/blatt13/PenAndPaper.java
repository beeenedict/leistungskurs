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
        Charakter a = A;
        Charakter b = B;
        int first = 0;
        if (B.initiative < A.initiative) {
            a = B;
            b = A;
            first = 1;
        }
        int angriff = 0;
        boolean advantage;
        boolean disadvantage;
        while (b.hitPoints > 0) {
            if (b.roundsAdvantage > 0) {
                advantage = true;
                b.roundsAdvantage--;
            }
            if (b.roundsAdvantage > 0) {
                disadvantage = true;
                b.roundsDisadvantage--;
            }
            angriff = angriff(b.damageN, b.damageX, a.armorClass, );
            a.hitPoints -= angriff;
            if (a.hitPoints <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Charakter Barbar = new Charakter("Barbar", 70, 14, 1, 1, 8, 0, 0, 3, 1);
        Charakter Barde = new Charakter("Barde", 42, 10, 2, 1, 6, 0, 3, 0, 2);

    }
}
