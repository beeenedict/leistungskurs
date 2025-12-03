package blatt13;

public class MonteCarlo {

    public static double piApproximation(double n){
        int drinnen = 0;
        int daneben = 0;
        double r = 0.5;
        double an = 0;
        double abs;

        while(Math.abs(Math.PI - an) > n){
            double x = Math.random() - r;
            double y = Math.random() - r;
            abs = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if(abs < r){
                drinnen++;
            }
            else{
                daneben++;
            }
            an = (double) (4 * drinnen) / (double) (daneben + drinnen);
        }
        return an;
    }

    public static void main(String[] args) {
        System.out.println("Monte Carlo: " + piApproximation(0.00001));
    }

    // c), d) In der Funktion piApproximation wird ein Näherungswert an Pi errechnet, die dem vierfachen der Wahrscheinlichkeit entspricht, ob ein Tropfen mit zufälliger Position im Brunnen landet. Hierfür wird sowohl die Randbreite des Brunnens als auch das Volumen bzw. die Fläche der Tropfen vernachlässigt.
}
