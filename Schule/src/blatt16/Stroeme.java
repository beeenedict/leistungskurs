package blatt16;

import blatt07.ArbeitMitArrays;
import blatt14.MultiArrays;

import java.io.*;

public class Stroeme {

    public static char[][] readCharArray(String fileName) {
        char c = File.separatorChar;
        char[][] arr = new char[0][0];
        try {
            File dir = new File("Schule" + c + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File f = new File(dir.getPath() + c + fileName);
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String s = "";
            int i = 0;
            int z = 0;
            int x = 0;
            int y = 0;
            while (bfr.ready()) {
                if (i == 0) {
                    x = Integer.parseInt(bfr.readLine());
                }
                else if (i == 1) {
                    y = Integer.parseInt(bfr.readLine());
                    arr = new char[x][y];
                }
                else {
                    if (i == y + 2) {
                        z++;
                        i -= y;
                    }
                    arr[z][i - 2] = bfr.readLine().charAt(0);
                }
                i++;
            }
            bfr.close();
            fr.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void writeCharArray(String fileName, char[][] arr) {
        char c = File.separatorChar;

        try {
            File dir = new File("Schule" + c + "io");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File f = new File(dir.getPath() + c + fileName);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    bfw.write(arr[i][j]);
                    bfw.newLine();
                }
            }

            bfw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeCharArray("test.txt", readCharArray("laby01.txt"));
    }
}