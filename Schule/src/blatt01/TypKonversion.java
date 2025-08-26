package blatt01;

public class TypKonversion {
    public static void main(String[] args) {
        int a = 14;
        double b = -21.25;

        int c = (int) b;
        double d = (double) a;

        System.out.println(c);
        System.out.println(d);

        char e = 'a';
        int f = 65;

        int g = (int) e;
        char h = (char) f;

        System.out.println(g);
        System.out.println(h);
        //a) Das Programm konvertiert verschiedene Datentypen ineinander -> typcasting
        //b) Die Variablen hinter dem Konstrukt werden in den angegebenen Datentyp konvertiert
        //c) Werte eines Datentyps entsprechen als anderer Datentyp einen anderen Wert, so hat der double 14.3 als int den Wert 14
        //d) Jeder Integer entspricht einem bestimmten Character und jeder Character einem Integer-Wert, wobei die ASCII-Tabelle zur Zuweisung genutzt wird
    }
}
