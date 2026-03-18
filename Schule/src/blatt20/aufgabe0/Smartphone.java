package blatt20.aufgabe0;

import java.util.Objects;

public class Smartphone {

    private String marke;
    private String modell;
    private int akkustand;
    private int preis;
    private int speicherplatz;
    private int helligkeit;
    private int lautstaerke;
    private int displaygroesse;
    private String betriebssystem;

    public Smartphone(String modell, int preis, int speicherplatz, int helligkeit, int lautstaerke, int displaygroesse, String betriebssystem, String marke) {
        this.modell = modell;
        this.akkustand = 100;
        this.preis = preis;
        this.speicherplatz = speicherplatz;
        this.helligkeit = 100;
        this.lautstaerke = 50;
        this.displaygroesse = displaygroesse;
        this.betriebssystem = betriebssystem;
        this.marke = marke;
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

    void akkuLaden(int l) {
        setAkkustand(this.akkustand + l);
    }

    boolean istAkkuLeer() {
        return this.akkustand == 0;
    }

    boolean hatGenugSpeicher(double size) {
        return this.speicherplatz > size;
    }

    void appInstallieren(int size) {
        if (hatGenugSpeicher(size)) {
            this.speicherplatz -= size;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone that)) return false;
        return preis == that.preis && speicherplatz == that.speicherplatz && displaygroesse == that.displaygroesse && Objects.equals(marke, that.marke) && Objects.equals(modell, that.modell) && Objects.equals(betriebssystem, that.betriebssystem);
    }
}

