package blatt21.aufgabe01;

public class Giesskanne {

    private boolean istAusgeruestet;
    private int stufe;
    private int wasserstand;
    private int wasserstandMax;
    private int wasserverbrauch;

    public Giesskanne() {
        this.istAusgeruestet = false;
        this.stufe = 1;
        this.wasserstand = 0;
        this.wasserstandMax = 30;
        this.wasserverbrauch = 1;
    }

    public void upgrade() {
        if (this.stufe < 4) {
            this.stufe++;
        }
        this.wasserstandMax = 30 + 15 * (this.stufe - 1);
        this.wasserverbrauch = (int) Math.pow(3, this.stufe - 1);
        if (this.stufe == 4) {
            this.wasserverbrauch -= 3;
        }
    }

    public void ausruesten() {
        this.istAusgeruestet = true;
    }

    public void ablegen() {
        this.istAusgeruestet = false;
    }

    public void fuellen() {
        this.wasserstand = this.wasserstandMax;
    }

    public void giessen() {
        this.wasserstand -= this.wasserverbrauch;
        if (this.wasserstand < 0) {
            this.wasserstand = 0;
        }
    }

    public int getStufe() {
        return this.stufe;
    }

    public boolean istAusgeruestet() {
        return this.istAusgeruestet;
    }

    public int getWasserstand() {
        return this.wasserstand;
    }

    public int getWasserstandMax() {
        return this.wasserstandMax;
    }

    public int getWasserverbrauch() {
        return this.wasserverbrauch;
    }
}
