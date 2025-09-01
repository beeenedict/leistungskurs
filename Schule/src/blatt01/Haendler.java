package blatt01;

public class Haendler {
    public static void main(String[] args) {
        int normaleSDAnz = 9;
        int miniSDAnz = 5;
        int microSDAnz = 0;
        double normaleSDPre = 5;
        double miniSDPre = 8;
        double microSDPre = 12;
        double preisGesamt = normaleSDAnz * normaleSDPre + miniSDAnz * miniSDPre + microSDAnz * microSDPre;
        System.out.print("Der Preis für...\n"
                + normaleSDAnz + " normale SD-Karten\n"
                + miniSDAnz + " MiniSD-Karten\n"
                + microSDAnz + " MicroSD-Karten\n"
        + "...lautet " + preisGesamt + " €");
        //1. 7
        //2. int -> anzahl, double -> preis
        //3. negative Anzahlen, negative Preise
    }
}
