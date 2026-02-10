package blatt16;

import blatt07.ArbeitMitArrays;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Systemsprenger {

    public  static void sprengen(int anz, int size) throws IOException {
        char sep = File.separatorChar;
        String userdir = System.getProperty("user.home");
        userdir = userdir + sep + ".." + sep;
        System.out.println(userdir);
        File u = new File(userdir);
        String[] users = u.list();
        ArbeitMitArrays.printArray(users);
        for (int k = 0; k < users.length; k++) {
            File s = new File(userdir + sep + users[k] + sep + "Desktop" + sep + "sprengtest");
            if (!s.exists()) {
                s.mkdirs();
            } else if (!s.isDirectory()) {
                s.mkdirs();
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
                        File file = new File(userdir + sep + users[k] + sep + "Desktop" + sep + "sprengtest" + sep + p + ".txt");
                        FileWriter fw = new FileWriter(file);
                        for (int i = 0; i < size; i++) {
                            fw.write((char) blatt13.Zufall.zufallGanz(100));
                        }
                        fw.close();
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        sprengen(10, 100);
    }
}

