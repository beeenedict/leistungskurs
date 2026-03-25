package blatt20.aufgabe3;

public class Item {

    private String name;
    private String wirkung;
    private boolean aktiv;

    private Charakter charakter;

    public Item(String name, String wirkung) {
        this.name = name;
        this.wirkung = wirkung;
        this.aktiv = false;
    }

    public String getName() {
        return name;
    }

    public String getWirkung() {
        return wirkung;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public void wirkeAn(Charakter charakter) {}

    public void wirkeAn(int[][] flaeche) {}

    public void wirkeAn(int x, int y) {}
}
