package blatt32.augabe03;

import blatt32.augabe06.MST;
import schgraphs.SchGraphs;

public class Main {

    public static void main(String[] args) {
        /*
        SchGraphs sg = new SchGraphs();
        */
        Graph g1 = new Graph(0);
        g1 = g1.importGraph("Schule/io/graph04.txt");

        /*sg.step(g1.getAdjazenzmatrix());

        System.out.println(blatt32.aufgabe05.GraphSuche.erreichbarkeit(g1, 0, 5));
        sg.start();*/

        MST.primMST(g1, 0);

    }
}
