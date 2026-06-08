package blatt21.aufgabe01;

public class Feld {

    private int wachstumsdauer;
    private int vergangeneTage;
    private int wert;
    private boolean bewaessert;

    public Feld(int wachstumsdauer) {
        this.wachstumsdauer = wachstumsdauer;
        this.vergangeneTage = 0;
        this.wert = (int) (1000 * Math.pow(1.12, wachstumsdauer - 1) + 125 * blatt13.Zufall.zufallGanz(-2, 4));
        this.bewaessert = false;
    }

    public void bewaessern() {
        this.bewaessert = true;
    }

    public void weiter() {
        if (this.bewaessert) {
            vergangeneTage++;
            this.bewaessert = false;
        }
    }

    public boolean istAusgewachsen() {
        return this.vergangeneTage >= this.wachstumsdauer;
    }

    public int getWert() {
        return this.wert;
    }
}
