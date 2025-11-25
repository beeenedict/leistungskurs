package blatt13;

public class Charakter {
    String name;
    int hitPoints;
    int armorClass;
    int attackB;
    int damageN;
    int damageX;
    int damageB;
    int roundsAdvantage;
    int roundsDisadvantage;
    int initiative;

    public Charakter(String name, int hitPoints, int armorClass, int attackB, int damageN, int damageX, int damageB, int roundsAdvantage, int roundsDisadvantage, int initiative) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.attackB = attackB;
        this.damageN = damageN;
        this.damageX = damageX;
        this.damageB = damageB;
        this.roundsAdvantage = roundsAdvantage;
        this.roundsDisadvantage = roundsDisadvantage;
        this.initiative = initiative;
    }
}
