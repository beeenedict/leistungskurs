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

    public Charakter(String name, int hitPoints, int armorClass, int attackB, int damageN, int damageX, int damageB, int roundsAdvantage, int roundsDisadvantage) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.armorClass = armorClass;
        this.attackB = attackB;
        this.damageN = damageN;
        this.damageX = damageX;
        this.damageB = damageB;
        this.roundsAdvantage = roundsAdvantage;
        this.roundsDisadvantage = roundsDisadvantage;
    }
}
