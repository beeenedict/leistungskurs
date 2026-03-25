package blatt20.aufgabe3;

public class Main {

    public static void main(String[] args) {

        Item panzer = new Item("Bowserpanzer", "Aua.");
        Item banane = new Item("Banane", "Rutschen.");
        Item ei = new Item("Yoshi's Ei", "Omelett.");

        Charakter bowser = new Charakter(Charaktername.BOWSER, Gewichtsklasse.SCHWER, panzer);
        Charakter donkeyKong = new Charakter(Charaktername.DONKEY_KONG, Gewichtsklasse.SCHWER, banane);
        Charakter yoshi = new Charakter(Charaktername.YOSHI, Gewichtsklasse.LEICHT, ei);


        Kart lkw = new Kart("LKW", 300, bowser, donkeyKong);
        Kart mowa = new Kart("Mowa", 20, yoshi, bowser);
        Kart boot = new Kart("Boot", 120, donkeyKong, yoshi);
    }
}
