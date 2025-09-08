package blatt04;

public class ETF {
    public static void main(String[] args) {
        double sparBetrag = 50;
        double gesamtBetrag = 0;
        double etfAnteil = 3578.89;
        double anteil;
        int monat = 0;

        while (monat < 12) {
            monat ++;
            gesamtBetrag += sparBetrag;
            anteil = gesamtBetrag / etfAnteil;

            System.out.println("Monat: " + monat);
            System.out.printf("Gesamtbetrag: %.2f%n", gesamtBetrag);
            System.out.printf("Anteil an einem ETF-Anteil: %.5f%n%n", anteil);
        }
    }
}
