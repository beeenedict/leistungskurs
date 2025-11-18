package blatt13;

public class PenAndPaper {

    public static int wuerfel(int N, int X) {
        int wert = 0;

        for (int i = 1; i < N; i++) {
            wert += Zufall.zufallGanz(1, X);
        }
        return wert;
    }

    public static int wuerfel(int N, int X, int b) {
        return wuerfel(N, X) + b;
    }

    public static void main(String[] args) {
        System.out.println(wuerfel(8, 6));
    }
}
