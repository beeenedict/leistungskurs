package blatt01;

public class Haendler {
    public static void main(String[] args) {
        int anz_no_SD = 9;
        int anz_mi_SD = 5;
        int anz_mc_SD = 0;
        double pr_no_SD = 5;
        double pr_mi_SD = 8;
        double pr_mc_SD = 12;
        double gesamtpreis = pr_no_SD * anz_no_SD + pr_mi_SD * anz_mi_SD + pr_mc_SD * anz_mc_SD;
        System.out.print("Der Preis für...\n"
                + anz_no_SD + " normale SD-Karten\n"
                + anz_mi_SD + " MiniSD-Karten\n"
                + anz_mc_SD + " MicroSD-Karten\n"
        + "...lautet " + gesamtpreis + " €");
        //1. 7
        //2. int -> anzahl, double -> preis
        //3. negative Anzahlen, negative Preise
    }
}
