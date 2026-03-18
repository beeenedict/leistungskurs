package blatt20.aufgabe0;

public class Auto {
    private String marke;
    private String modell;

    private int tank;
    private int geschwindigkeit;
    private int kilometerstand;

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

    public int getTank() {
        return this.tank;
    }
    public void setTank(int tank) {
        this.tank = Math.max(tank, 0);
        this.tank = Math.min(this.tank, 100);
    }

    public int getGeschwindigkeit() {
        return this.geschwindigkeit;
    }
    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = Math.max(geschwindigkeit, 0);
        this.geschwindigkeit = Math.min(this.geschwindigkeit, 300);
    }

    public String getMarke() {
        return marke;
    }
    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }
    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }
    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = Math.max(kilometerstand, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto)) return false;
        Auto a = (Auto) o;
        return this.marke.equals(a.marke) && this.modell.equals(a.modell);
    }
}
