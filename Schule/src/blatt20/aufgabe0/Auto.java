package blatt20.aufgabe0;

public class Auto {
    String marke;
    String modell;

    int tank;
    int geschwindigkeit;
    int kilometerstand;

    void beschleunigen(int v) {
        this.geschwindigkeit += v;
    }

    void bremsen (int v) {
        this.geschwindigkeit -= v;
    }

    void fahren(int km) {
        this.kilometerstand += km;
    }

    public Auto() {
        this.marke = "unbekannt";
        this.modell = "unbekannt";
        this.tank = 50;
        this.geschwindigkeit = 0;
        this.kilometerstand = 0;
    }

    public Auto(Auto a) {
        this.marke = a.marke;
        this.modell = a.modell;
        this.tank = a.tank;
        this.geschwindigkeit = a.geschwindigkeit;
        this.kilometerstand = a.kilometerstand;
    }

    public Auto(String marke, String modell, int tank, int geschwindigkeit, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.tank = tank;
        this.geschwindigkeit = geschwindigkeit;
        this.kilometerstand = kilometerstand;
    }
}
