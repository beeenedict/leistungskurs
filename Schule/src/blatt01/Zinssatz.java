package blatt01;

public class Zinssatz {
    public static void main(String[] args) {
        double kapital = 1220.0;
        double zinssatz = 2.25;
        double zinsen = kapital * zinssatz / 100;
        double neuesKapital = kapital + zinsen;

        System.out.printf("Altes Kapital: %.2f €%n", kapital);
        System.out.printf("Zinssatz: %f %% %n%n", zinssatz);
        System.out.printf("Zinsen: %.2f €%n", zinsen);
        System.out.printf("Neues Kapital: %.2f €", neuesKapital); // ... + kapital + ... (Startkapital nicht gespeichert)
    }
}
