package blatt13;

public class PenAndPaper {

    /**
     * Simuliert den Wurf von N X-seitigen Würfeln
     * @param N int
     * @param X int
     * @return int Wurf
     */

    public static int wuerfel(int N, int X) {
        int wert = 0;

        for (int i = 0; i < N; i++) {
            wert += Zufall.zufallGanz(1, X);
        }
        return wert;
    }

    /**
     * Simuliert den Wurf von N X-seitigen Würfeln mit Bonus
     * @param N int
     * @param X int
     * @param b int
     * @return int Wurf
     */

    public static int wuerfel(int N, int X, int b) {
        return wuerfel(N, X) + b;
    }

    /**
     * Führt einen d20 check durch und überprüft, ob dieser nach gegebenem difficulty bestanden wurde.
     * @param difficulty int
     * @param vor boolean
     * @param nach boolean
     * @return boolean
     */

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

    /**
     * Führt einen d20 check mit Bonus durch und überprüft, ob dieser nach gegebenem difficulty bestanden wurde.
     * @param difficulty int
     * @param vor boolean
     * @param nach boolean
     * @param b Bonus int
     * @return boolean
     */

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
            return 0;
        }
    }

    public static int angriff(int N, int X, int enemyAC, boolean vor, boolean nach, int atkB, int dmgB) {
        boolean treffer = check(enemyAC, vor, nach, atkB);

        if (treffer) {
            return wuerfel(N, X, dmgB);
        }
        else {
            return 0;
        }
    }

    public static int meleeFight(Charakter A, Charakter B) {
        Charakter[] charakters = new Charakter[2];
        if (A.initiative < B.initiative) {
            charakters[0] = A;
            charakters[1] = B;
        }
        else {
            charakters[0] = B;
            charakters[1] = A;
        }
        int angriff = 0;
        boolean advantage = false;
        boolean disadvantage = false;
        while (charakters[0].hitPoints > 0 && charakters[1].hitPoints > 0) {
            for (int i = 0; i < charakters.length; i++) {
                if (charakters[i].roundsAdvantage > 0) {
                    advantage = true;
                    charakters[i].roundsAdvantage--;
                }
                if (charakters[i].roundsAdvantage > 0) {
                    disadvantage = true;
                    charakters[i].roundsDisadvantage--;
                }
                angriff = angriff(charakters[i].damageN, charakters[i].damageX, charakters[Math.abs(i - 1)].armorClass, advantage, disadvantage, charakters[i].attackB, charakters[i].damageB);
                charakters[Math.abs(i - 1)].hitPoints -= angriff;

                if (charakters[Math.abs(i - 1)].hitPoints <= 0) {
                    System.out.println(charakters[i].name + " hat gewonnen!");
                    return i;
                }
                advantage = false;
                disadvantage = false;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int barde = 0;
        for (int i = 0; i < 100; i++) {
            Charakter Barbar = new Charakter("Barbar", 70, 14, 1, 1, 8, 0, 0, 3, 1);
            Charakter Barde = new Charakter("Barde", 42, 18, 2, 1, 6, 0, 3, 0, 2);
            barde += meleeFight(Barbar, Barde);
        }
        System.out.println("Barde: " + barde);
        System.out.println("Barbar: " + (100 - barde));
    }

    // Barde: Rüstungsklasse 10 -> 18
}
