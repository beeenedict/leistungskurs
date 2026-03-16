package blatt20.aufgabe0;

public class Smartphone {

    private String marke;
    private String modell;
    private int akkustand;
    private int preis;
    private int speicherplatz;

    public Smartphone(int speicherplatz, int preis, String modell, String marke) {
        this.speicherplatz = speicherplatz;
        this.preis = preis;
        this.modell = modell;
        this.marke = marke;
        this.akkustand = 100;
    }

    public int getAkkustand() {
        return akkustand;
    }
    public void setAkkustand(int akkustand) {
        this.akkustand = Math.max(akkustand, 0);
        this.akkustand = Math.min(akkustand, 100);
    }

    public int getPreis() {
        return preis;
    }
    public void setPreis(int preis) {
        this.preis = Math.max(preis, 0);
    }

    public int getSpeicherplatz() {
        return speicherplatz;
    }
    public void setSpeicherplatz(int speicherplatz) {
        this.speicherplatz = Math.max(speicherplatz, 0);
    }

    void nutzen(int l) {
        setAkkustand(this.akkustand - l);
    }

    void laden(int l) {
        setAkkustand(this.akkustand + l);
    }
}
