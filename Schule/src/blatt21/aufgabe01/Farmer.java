package blatt21.aufgabe01;

public class Farmer {

    private String name;
    private String farmName;
    private int energie;
    private final int ENERGIE_MAX = 50;
    private int vermoegen;
    private Axt axt;
    private Giesskanne giesskanne;
    private final int[] UPGRADE_PREISE = new int[]{2500, 10000, 20000};

    private Feld[] farm;
    private Baum[] baeume;

    public Farmer(String name, String farmName) {
        this.name = name;
        this.farmName = farmName;
        this.axt = new Axt();
        this.giesskanne = new Giesskanne();
        this.energie = ENERGIE_MAX;
        this.vermoegen = 1000;
        this.farm = new Feld[200];
        for (int i = 0; i < this.farm.length; i++) {
            this.farm[i] = new Feld(blatt13.Zufall.zufallGanz(2,10));
        }
        this.baeume = new Baum[3];
    }

    public void schlafen() {
        this.energie = ENERGIE_MAX;
        for (int i = 0; i < this.farm.length; i++) {
            this.farm[i].weiter();
            if (this.farm[i].istAusgewachsen()) {
                this.vermoegen += this.farm[i].getWert();
                farm[i] = new Feld(blatt13.Zufall.zufallGanz(2,10));
            }
        }
        if (this.axt.getStufe() < 4) {
            if (this.vermoegen > UPGRADE_PREISE[this.axt.getStufe() - 1]) {
                this.axt.upgrade();
                this.vermoegen -= UPGRADE_PREISE[this.axt.getStufe() - 1];
            }
        }
        if (this.giesskanne.getStufe() < 4) {
            if (this.vermoegen > UPGRADE_PREISE[this.giesskanne.getStufe() - 1]) {
                this.giesskanne.upgrade();
                this.vermoegen -= UPGRADE_PREISE[this.giesskanne.getStufe() - 1];
            }
        }
        baueme();
    }

    public void energie() {
        this.energie--;
        if (this.energie == 0) {
            schlafen();
        }
    }

    public void ausruestenAxt() {
        this.giesskanne.ablegen();
        this.axt.ausruesten();
        this.energie();
    }

    public void ausruestenGiesskanne() {
        this.axt.ablegen();
        this.giesskanne.ausruesten();
        this.energie();
    }

    public void baueme() {
        for (int i = 0; i < this.baeume.length; i++) {
            if (this.baeume[i] == null) {

            }
        }
    }
}
