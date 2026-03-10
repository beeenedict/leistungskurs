package blatt20.aufgabe1;

public class Kaffeemaschine {

    final int BOHNEN_MAX = 350;
    double bohnen;

    final int WASSER_MAX = 800;
    int wasser;

    final double[] DRECK_MAX = new double[]{0.5, 0.75, 0.9};
    double dreck;

    final int KAFFEESATZ_MAX = 100;
    double kaffeesatz;

    public void bohnenAuffuellen() {
        this.bohnen = BOHNEN_MAX;
    }

    public void bohnenLeeren() {
        this.bohnen = 0;
    }

    public void wasserAuffuellen() {
        this.wasser = WASSER_MAX;
    }

    public void wasserLeeren() {
        this.wasser = 0;
    }

    public void wasserReinigen() {
        if (this.wasser > 0) {
            System.out.println("Leeren Sie zuerst den Wasserbehälter");
            //this.wasserLeeren();
            //this.dreck = 0;
        } else {
            this.dreck = 0;
        }
    }

    public void kaffeesatzLeeren() {
        this.kaffeesatz = 0;
    }

    public void kaffeeZiehen(int menge, int intens) {
        if (intens > 10) {
            intens = 10;
        } else if (intens < 1) {
            intens = 1;
        }
        if (menge > 200) {
            menge = 200;
        } else if (menge < 10) {
            menge = 10;
        }

        if (this.bohnen < (double) menge / 20 * intens) {
            System.out.println("Füllen Sie die Kaffeebohnen auf.");
            return;
            //this.bohnenAuffuellen();
            //break;
        } else if (this.wasser < menge) {
            System.out.println("Füllen Sie das Wasser auf.");
            return;
            //this.wasserAuffuellen();
            //break;
        } else if (this.kaffeesatz +  (double) menge / 20 * intens >= KAFFEESATZ_MAX) {
            System.out.println("Bitte leeren Sie zuerst den Kaffeesatzbehälter.");
            return;
            //this.kaffeesatzLeeren();
            //break;
        } else if (this.dreck > DRECK_MAX[2]) {
            System.out.println("Reinigen Sie den Wasserbehälter.");
            return;
            //this.wasserReinigen();
            //break;
        } else if (this.dreck > DRECK_MAX[1] && Math.random() < 0.5) {
            System.out.println("Reinigen Sie bitte zuerst den Wasserbehälter.");
            return;
        } else if (this.dreck > DRECK_MAX[0] && this.dreck < DRECK_MAX[1] && Math.random() < 0.25) {
            System.out.println("Bitte reinigen Sie zuerst den Wasserbehälter.");
            return;
        }
        else {
            this.wasser -= menge;
            this.bohnen -= (double) menge / 20 * intens;
            this.kaffeesatz += (double) menge / 20 * intens;
            this.dreck += 0.01;
        }

        System.out.println("Genießen Sie Ihren Kaffee, es könnte Ihr letzter sein.");
        System.out.println();
        System.out.println("- Kaffee -");
        System.out.println("Intensität: " + intens + " / 10");
        System.out.println("Temperatur: perfekt");
        System.out.println();
        System.out.println("- Kaffeemaschine -");
        System.out.println("Bohnen: " + this.bohnen);
        System.out.println("Wasser: " + this.wasser);
        System.out.printf("Dreck: %.2f%n", this.dreck);
        System.out.println("Kaffeesatz: " + this.kaffeesatz);
        System.out.println();
    }

    public void kaffeeSlotMachine(int menge, int intens, int anz) {
        for (int i = 0; i <= anz; i++) {
            this.kaffeeZiehen(menge, intens);
        }
    }

    public static void main(String[] args) {
        Kaffeemaschine k = new Kaffeemaschine();
        k.bohnenLeeren();
        k.wasserLeeren();
        k.wasserReinigen();
        k.bohnenAuffuellen();
        k.wasserAuffuellen();
        k.kaffeesatzLeeren();
        k.kaffeeZiehen(10, 1);
        k.kaffeeSlotMachine(10, 1, 100);
    }
}
