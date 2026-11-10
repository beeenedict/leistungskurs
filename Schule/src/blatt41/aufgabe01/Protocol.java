package blatt41.aufgabe01;

public class Protocol {
    private int zustand;
    private String raw;
    private String message;
    private Type type;

    public Protocol(String raw) {
        this.raw = raw;
        this.message = raw.substring(raw.lastIndexOf('|') + 1);
    }

    public void setZustand(int zustand) {
        this.zustand = zustand;
    }

    public String getRaw() {
        return raw;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getZustand() {
        //switch (this.getRaw().) {}
        return 0;
    }

}
