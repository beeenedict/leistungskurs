package blatt06;

public class HandwerkerFinanzen {
    public static void main(String[] args) {
        int[] auftraege = new int[]{9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};
        int summe = 0;

        int zwischenS = auftraege[1];
        auftraege[1] = auftraege[6];
        auftraege[6] = zwischenS;

        zwischenS = auftraege[0];
        for (int i = 0; i < auftraege.length - 1; i++) {
            auftraege[i] = auftraege[i + 1];
        }
        auftraege[auftraege.length - 1] = zwischenS;

        for (int i = 0; i < auftraege.length - 1; i++) {
            System.out.println(auftraege[i]);
        }

        for (int i = 0; i < auftraege.length; i++) {
            summe += auftraege[i];
        }
        System.out.println("Summe: " + summe);

        System.out.println("\nFolgende Aufträge haben einen Wert über 15000€");
        for (int i = 0; i < auftraege.length; i++) {
            if (auftraege[i] > 15000) {
                System.out.println((i + 1) + ". " + auftraege[i]);
            }
        }
    }
}
