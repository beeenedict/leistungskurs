package blatt41.aufgabe01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Message {
    private String message;
    private String protokoll;

    public Message() {
        this.message = "";
        this.protokoll = "";
    }

    public Message(String message, String protokoll) {
        this.message = message;
        this.protokoll = protokoll;
    }

    public String prepareMessage() {
        if (!protokoll.isEmpty()) {
            return this.protokoll + "|" +  this.message;
        }
        return "ERR";
    }

    public boolean sendMessage(Socket socket) throws IOException {
        String message = this.prepareMessage();
        if (socket != null && message != "ERR") {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);

            return true;
        } return false;
    }

    public boolean isValid(String msg) {
        return msg != null && msg.contains("|") && msg.indexOf("|") > 0;
    }

    public String extractProtokoll(String msg) {
        return msg.substring(0, msg.indexOf("|"));
    }

    public String extractMessage(String msg) {
        return msg.substring(msg.indexOf("|") + 1);
    }

    public void setMessage(String message) {
        this.message = message.substring(message.indexOf("|") + 1);
        this.protokoll = message.substring(0, message.indexOf("|"));
    }
}
