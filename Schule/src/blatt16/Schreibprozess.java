package blatt16;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Schreibprozess {
    public static void schreibeTest01() throws IOException {
        char sep = File.separatorChar;
        try {
            File dir = new File("Schule" + sep + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File f = new File(dir.getPath() + sep + "Test01.text");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("Niemals funktioniert das.");
            bfw.newLine();
            bfw.write("Doch tut es.");
            bfw.newLine();
            bfw.write("Code kopieren ist toll.");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void schreibeTest02() throws IOException {
        char sep = File.separatorChar;
        try {
            File dir = new File("Schule" + sep + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File f = new File(dir.getPath() + sep + "Test02.html");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("<!DOCTYPE html><html><head><title>HTML aus Java</title></head><body><h1>HTML aus Java?</h1><p>Es geht. Wirklich.</p></body></html>");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        schreibeTest01();
        schreibeTest02();
    }
}