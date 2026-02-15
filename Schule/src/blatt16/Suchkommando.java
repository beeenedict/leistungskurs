package blatt16;

import blatt07.ArbeitMitArrays;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Suchkommando {
    public static String[] suchen(){
        List<String> filePaths = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String file = input.nextLine();
        String user = System.getProperty("user.home");
        String filePath = user;
        String[] dirs;
        do { //TODO: file suchen, appenden, repeat, backstep...
            File fileAct = new File(filePath);
            dirs = fileAct.list();
            filePath += dirs;
        } while (dirs.length > 0);

        int l = filePaths.size();
        return filePaths.toArray(new String[l]);
    }

    public static void main(String[] args){
        ArbeitMitArrays.printArray(suchen());
    }
}
