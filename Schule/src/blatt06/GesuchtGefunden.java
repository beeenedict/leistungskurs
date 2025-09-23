package blatt06;

public class GesuchtGefunden {
    public static void main(String[] args) {
        double[] arr = new double[] {3.45, 7, 14, -66, 5.4, 33.33, 99.1, 42.3, 3.14, -3.14, 13.56, 7.8031, -54.35, 6.120, 6.435, -2.30001, 0.00005, -65.78, -29.57, 92, -83, 3174.56, -1469.349, -5.086, 27.135, 348.5, 52.3568, -47.320051, 8372.579, -593.2, 0.25874, -7.1952, 3587.6, -201.3, -65.92, 12, 5, 13.7, -30, 16.5, 10071, 1700.34, -50.05, 81.3576, -42};

        double kleinste = arr[0];
        double groesste = arr[0];
        double summe = 0;
        double paardifferenz = Math.abs(arr[1] - arr[0]);
        int traumpaar = 0;
        double pd;

        for (int i = 0; i < arr.length; i++) {

            if (i < arr.length - 2) {
                pd = Math.abs(arr[i + 1] - arr[i]);

                if (pd < paardifferenz){
                    paardifferenz = pd;
                    traumpaar = i;
                }
            }
            if (arr[i] < kleinste) {
                kleinste = arr[i];
            }
            if (arr[i] > groesste) {
                groesste = arr[i];
            }
            summe += arr[i];
        }
        System.out.println();
        System.out.println("Kleinster Wert: " + kleinste);
        System.out.println("Groesster Wert: " + groesste);
        System.out.println("Summe der Werte: " + summe);
        System.out.printf("kleinste Paardifferenz: %.3f%n", paardifferenz);
        System.out.println("Traumpaar: " + traumpaar + ", " + (traumpaar + 1));
    }

}
