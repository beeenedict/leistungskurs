package blatt20.aufgabe2;

public class Kochfeld {
    final int HITZE_MAX = 6;
    final int HITZE_MIN = 0;
    int hitze;

    final String[] FELDGROESSEN = new String[]{"S", "M", "L", "XL"};
    int groesse;

    void heisser() {
        if (this.hitze < HITZE_MAX) {
            this.hitze++;
        }
    }

    void kaelter() {
        if (this.hitze > HITZE_MIN) {
            this.hitze--;
        }
    }
}
