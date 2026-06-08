package blatt21.aufgabe01;

public class Baum {

    private int haltbarkeit;

    public Baum(int haltbarkeit) {
        this.haltbarkeit = haltbarkeit;
        if (this.haltbarkeit < 5 || this.haltbarkeit > 20) {
            this.haltbarkeit = 5;
        }
    }

    public void hacken() {
        this.haltbarkeit--;
        if (this.haltbarkeit < 0) {
            this.haltbarkeit = 0;
        }
    }
}
