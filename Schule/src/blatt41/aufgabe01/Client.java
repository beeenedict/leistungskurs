package blatt41.aufgabe01;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String a = "asdb|abc";
        System.out.println(a.substring(a.lastIndexOf('|') + 1));
        Socket socket = new Socket("10.8.48.87", 2718);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Message m = new Message("MSG", "PRT");
        m.sendMessage(socket);
        m.setMessage("QST|Wann kommt Sea of Sorrow raus?");
        m.sendMessage(socket);
        String antwort = in.readLine();
        System.out.println(antwort);
        m.setMessage("XD|haha no way");
        m.sendMessage(socket);
        Scanner input = new Scanner(System.in);
        while(true) {
            String aas = new Scanner(System.in).nextLine();
            m.setMessage("QST|" + aas);
            m.sendMessage(socket);

            antwort = in.readLine();
            System.out.println(antwort);
            if (antwort.contains("$")){
                System.out.println("SESSION VORBEI");
                m.setMessage("FIN|");
                m.sendMessage(socket);
                socket.close();
                break;
            }
        }
    }
}
