package blatt20.aufgabe0;

import blatt13.Zufall;
import java.util.Date;

public class Nutzer {

    private String nutzername;
    private String email;
    private Date geburtsdatum;
    private Date erstellungsdatum;
    private String passwort;
    private int guthaben;
    private boolean istAngemeldet;

    public Nutzer(String nutzername, String email, Date geburtsdatum, Date erstellungsdatum, String passwort) {
        this.nutzername = nutzername;
        this.email = email;
        this.geburtsdatum = geburtsdatum;
        this.erstellungsdatum = erstellungsdatum;
        this.passwort = passwort;
        this.guthaben = 5;
        this.istAngemeldet = false;
    }

    /**
     * Anmeldesystem
     * @param name String
     * @param pass String
     */

    public void anmelden(String name, String pass) {
        if (this.passwort.equals(pass)) {
            System.out.println("Wilkommen " + name);
            this.istAngemeldet = true;
        }
    }

    /**
     * Abmelden
     */

    public void abmelden() {
        this.istAngemeldet = false;
    }

    /**
     * Passwort ändern
     * @param passwortAlt String
     * @param passwortNeu String
     */

    public void passwortAendern(String passwortAlt, String passwortNeu) {
        if (this.passwort.equals(passwortAlt)) {
            this.passwort = passwortNeu;
            System.out.println("Ihr Passwort wurde erfolgreich geändert.");
        } else {
            System.out.println("Ihr Passwort stimmt nicht überein.");
        }
    }

    /**
     * Einlösen eines Gutscheins mit Code
     * @param code int
     */

    public void gutscheinEinloesen(int code) {
        if (this.istAngemeldet) {
            if (code > 0 && code < 999999) {
                this.guthaben += Zufall.zufallGanz(1000);       //TODO: Möglicherweise keine zufällige Anzahl and Guthaben zuweisen
            } else {
                System.out.println("Dieser Code ist nicht gültig.");
            }
        } else {
            System.out.println("Sie sind nicht angemeldet.");
        }
    }

    //Super!

    /**
     * Gibt das Guthaben zurück.
     * @return int
     */

    public int getGuthaben() {
        if (this.istAngemeldet) {
            return this.guthaben;
        } else {
            System.out.println("Sie sind nicht angemeldet.");
            return -1;
            //Nichts auszusetzen!
        }
    }
}
