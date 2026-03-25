package blatt20.aufgabe3;

public class Kart {

    private String modellName;
    private double maxGeschwindigkeit;
    private double beschleunigung;

    private Charakter charakter1;
    private Charakter charakter2;

    public Kart(String modellName, double maxGeschwindigkeit, Charakter charakter1, Charakter charakter2) {
        this.modellName = modellName;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.beschleunigung = 0;
        this.charakter1 = charakter1;
        this.charakter2 = charakter2;
    }

    public String getModellName() {
        return modellName;
    }

    public double getMaxGeschwindigkeit() {
        return maxGeschwindigkeit;
    }

    public double getBeschleunigung() {
        return beschleunigung;
    }

    public void setBeschleunigung(double beschleunigung) {
        this.beschleunigung = beschleunigung;
    }

    public void beschleunige() {}

    public void bremse() {}
}
