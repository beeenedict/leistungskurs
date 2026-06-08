package blatt21.aufgabe01;

public class Axt {

    private boolean istAusgeruestet;
    private int stufe;
    private int schaden;

    public Axt() {
        this.istAusgeruestet = false;
        this.stufe = 1;
        this.schaden = 1;
    }

    public void upgrade() {
        if (this.stufe < 4) {
            this.stufe++;
            this.schaden = this.stufe + this.stufe / 3 + this.stufe / 4;
        }
    }

    public int getStufe() {
        return this.stufe;
    }

    public boolean istAusgeruestet() {
        return this.istAusgeruestet;
    }

    public void ausruesten() {
        this.istAusgeruestet = true;
    }

    public void ablegen() {
        this.istAusgeruestet = false;
    }
}
