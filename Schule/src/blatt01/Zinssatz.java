package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double kapital = 1220.0;
        double zinssatz = 2.25;
        double zinsen = kapital * zinssatz / 100;
        double n_kapital = kapital + zinsen;

        System.out.println("Altes Kapital: " + kapital + " €");
        System.out.println("Zinssatz: " + zinssatz + " %\n");
        //kapital += zinsen;
        System.out.println("Zinsen: " + zinsen + " €");
        System.out.println("Neues Kapital: " + n_kapital + " €"); // ... + kapital + ... (Startkapital nicht gespeichert)
    }
}
