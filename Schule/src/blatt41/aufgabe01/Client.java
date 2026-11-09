package blatt41.aufgabe01;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static String antw() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.8.205.28", 753);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("HALLO");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String antwort = in.readLine();
        System.out.println(antwort);
        antwort = in.readLine();
        System.out.println(antwort);

        out.println("HERR SCHISCH");

        antwort = in.readLine();
        System.out.println(antwort);

        out.println("20");

        antwort = in.readLine();
        System.out.println(antwort);

        antwort = in.readLine();
        System.out.println(antwort);

        out.println("HOWDY!");

        antwort = in.readLine();
        System.out.println(antwort);

        out.println("GERNE");

        socket.close();
    }
}
