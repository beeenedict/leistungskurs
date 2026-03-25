package blatt20.aufgabe3;

public class Charakter {

    private Charaktername name;
    private Gewichtsklasse gewichtsklasse;
    private Item spezialItem;

    private Kart kart;

    public Charakter(Charaktername name, Gewichtsklasse gewichtsklasse, Item spezialItem) {
        this.name = name;
        this.gewichtsklasse = gewichtsklasse;
        this.spezialItem = spezialItem;
    }

    public Charaktername getName() {
        return name;
    }

    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    public Item getSpezialItem() {
        return spezialItem;
    }

    public void lenkeKart(Kart kart) {}

    public void halteItem(Item item) {}

    public void wirfItem(Item item) {}
}
