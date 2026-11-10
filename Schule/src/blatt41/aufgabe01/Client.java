package blatt41.aufgabe01;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String a = "asdb|abc";
        System.out.println(a.substring(a.lastIndexOf('|') + 1));
        Socket socket = new Socket("10.8.48.87", 2718);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("exit");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String antwort = in.readLine();
        System.out.println(antwort);

        socket.close();
    }
}
