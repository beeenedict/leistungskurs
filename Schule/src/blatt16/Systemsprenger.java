package blatt16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Systemsprenger {

    public  static void sprengen(int anz, int size) throws IOException {
        char sep = File.separatorChar;
        String userdir = System.getProperty("user.home");
        File u = new File(userdir);
        File s = new File(userdir + sep + "Desktop" + sep + "sprengtest");
        if (!s.exists()) {
            s.mkdirs();
        } else if (!s.isDirectory()) {
            //s.mkdirs();
        }
        String[] g = s.list();
        if (g != null) {
            int j;
            if (g.length > 0) {
                j = g.length;
            } else {
                j = 0;
            }
            for (int p = j; p < anz + j; p++) {
                File file = new File(userdir + sep + "Desktop" + sep + "sprengtest" + sep + "bumm" + p + ".txt");
                FileWriter fw = new FileWriter(file);
                for (int i = 0; i < size; i++) {
                    fw.write((char) blatt13.Zufall.zufallGanz(100));
                }
                fw.close();
            }
        }
    }

    public static void reinigen() throws IOException {
        char sep = File.separatorChar;
        String userdir = System.getProperty("user.home");
        File u = new File(userdir);
        File s = new File(userdir + sep + "Desktop" + sep + "sprengtest");
        if (!s.exists()) {
            return;
        } else if (!s.isDirectory()) {
            return;
        }
        File[] g = s.listFiles();
        if (g != null && g.length != 0) {
            String f;
            for (int i = 0; i < g.length; i++) {
                f = g[i].getName();
                if (f.endsWith(".txt") && f.startsWith("bumm")) {
                    g[i].delete();
                }
            }
        }
        else if (s.exists()) {
            s.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        sprengen(10, 100);
        //reinigen();
    }
}

