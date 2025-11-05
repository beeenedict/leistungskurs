package blatt10;

public class Aufwand {
    static int o = 0;
    static int b = 0;

    public static int zahlDerUmbrueche(char[] charr) {
        int sp = 0;
        int count = 0;
        o++;
        sp += 32;

        o++;
        sp += 32;
        for (int i = 0; i < charr.length-1; i++) {
            b++;
            o += 3;

            if (charr[i] == '.') {
                if (charr[i+1] == ' ') {
                    count++;
                    o += 2;
                }
                o++;
                b++;
            }
            b++;
        }
        System.out.println("Speicheraufwand zahlDerUmbrueche: " + sp);
        return count;
    }

    public static char[] umbrueche(String s) {
        int sp = 0;
        char[] charr = s.toCharArray();
        sp += 16 * charr.length;
        int c = zahlDerUmbrueche(charr);
        sp += 32;
        int k = 0;
        sp += 32;
        char[] charr2 = new char[charr.length+c];
        sp += 16 * charr2.length;
        o += 5;
        while (c > 0) {
            b++;

            o++;
            sp += 32;
            for (int i = 0; i < charr.length-1; i++) {
                b++;
                o += 3;
                if (charr[i] == '.') {
                    if (charr[i+1] == ' ') {
                        charr2[i] = charr[i];
                        charr2[i+1] = '\n';
                        k++;
                        c--;
                        o += 7;
                    } else {
                        charr2[i+k] = charr[i];
                        o += 2;
                    }
                    b++;
                    o++;
                }
                else {
                    if (charr[i] == ' ' && charr[i-1] == '.') {

                    } else {
                    charr2[i] = charr[i];
                    o++;
                }
                    o ++;
                    b += 3;

                }
                b++;
            }
        }
        System.out.println("Speicheraufwand umbrueche: " + sp);
        return charr2;
    }

    public static void main(String[] args) {
        int sp = 0;
        String eingabe = "Nussecken (1 Blech). Teig: 300g Mehl, 1 TL Backpulver, 130g Zucker, 1 Pkg Vanillezucker, 2 EL Leinsamen, 6 EL Wasser, 130g Margarine/Butter. Belag: 200g Margarine/Butter, 6 EL Wasser, 200g Zucker, 1 Pkg Vanillezucker, 400g gemahlene Haselnüsse/Mandeln. Außerdem: Erdbeer-/Himbeermarmelade, 100g Zartbitterschokolade. Schritte: Die Leinsamen in 6 EL Wasser aufquellen lassen. Alle Zutaten für den Teig vermischen und zu einem relativ weichen Teig zerkneten, dann auf einem mit Backpapier ausgelegten Backbleck dünn drücken. Marmelade dünn auf dem Teig verteilen. Margarine, Wasser, Zucker und Vanillezucker in einem Topf schmelzen und kurz aufkochen lassen, dann Nüsse dazugeben und alles vermischen. Belag auf der Marmelade verteilen. Im vorgeheizten Backofen bei 180° C Ober/Unterhitze oder 160° C Umluft ca. 30 Minuten backen. Glasur erwärmen und mit einem Löffel über das Blech sprenkeln (so wird es gleichmäßiger und geht schneller als die Ecken in Schokolade zu tunken), abkühlen lassen. Zu Ecken schneiden.";
        sp += 16 * eingabe.length();
        o++;
        char[] ausgabe = umbrueche(eingabe);
        sp += 16 * ausgabe.length;
        o++;
        System.out.println(eingabe);
        System.out.println(ausgabe);

        System.out.println("Speicheraufwand main: " + sp);
        System.out.println(o + " Operationen, " + b + " Bedingungen, ");
    }

    /*

    d)
        Das Programm ist stabil.

    e)
        Für den Speicher ist der Aufwand direkt von der Länge des Strings eingabe abhängig. Best-Case: eingabe.length() = 0, "Worst-Case": möglichst langer String

     */

}