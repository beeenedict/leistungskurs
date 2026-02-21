package blatt16;

import blatt07.ArbeitMitArrays;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Suchkommando {

    static ArrayList<String> dirPaths = new ArrayList<>();
    static ArrayList<String> foundFiles = new ArrayList<>();

    public static String[] sucheStarten(){
        Scanner input = new Scanner(System.in);
        System.out.println("Geben Sie den Dateinamen der gesuchten Datei an.");
        String fileName = input.nextLine();
        String currentPath;

        File[] roots = File.listRoots();
        for(int i = 0; i < roots.length ; i++) {
            dirPaths.add(roots[i].getAbsolutePath());
            System.out.println(dirPaths.get(i));
        }

        char c = File.separatorChar;
        String[] files;
        do {
            currentPath = dirPaths.getFirst();
            File file = new File(currentPath);
            files = file.list();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    file = new File(currentPath + c + files[i]);
                    if (file.isDirectory()) {
                        dirPaths.add(currentPath + c + files[i]);
                    } else if (files[i].equals(fileName)) {
                        foundFiles.add(currentPath + c + files[i]);
                        ArbeitMitArrays.printArray(foundFiles.toArray(new String[0]));
                        System.out.println("Wollen Sie weitersuchen? (y/n)");
                        String answer = input.nextLine();
                        if (answer.equals("n")) {
                            return foundFiles.toArray(new String[0]);
                        }
                    }
                }
            }
            dirPaths.removeFirst();
        } while (!dirPaths.isEmpty());

        if (foundFiles.isEmpty()) {
            return null;
        }
        return foundFiles.toArray(new String[0]);
    }

    public static void main(String[] args){
        ArbeitMitArrays.printArray(Objects.requireNonNull(sucheStarten()));
    }
}
