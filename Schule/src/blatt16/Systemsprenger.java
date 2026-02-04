package blatt16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Systemsprenger {
    public  static void sprengen(int wert) throws IOException {
        File s = new File("sprengtest");
        if(!s.exists()){
            s.mkdir();
        } else if (!s.isDirectory()) {
            s.mkdir();
        }else {
            File[] g = s.listFiles();
            int j = 0;
            if (g.length > 0) {
                j = g.length;
            }
            else {
                j = 0;
            }
            for (int p = j; p + j < wert+ j; p++) {
                File file = new File("sprengtest\\sprengtest" + p + ".txt");
                FileWriter fw = new FileWriter(file);
                for (int i = 0; i <  2147483647; i++) {
                    fw.write((char)blatt13.Zufall.zufallGanz(100));
                }
                fw.close();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        sprengen(1);
    }
}

