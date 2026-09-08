package blatt32.augabe03;

import blatt32.augabe06.MST;
import schgraphs.SchGraphs;

import static blatt34.aufgabe02.Dijkstra.*;

public class Main {

    public static void main(String[] args) {

        SchGraphs sg = new SchGraphs();

        Graph g1 = new Graph(0);
        g1 = g1.importGraph("Schule/io/graph04.txt");

        /*sg.step(g1.getAdjazenzmatrix());

        System.out.println(blatt32.aufgabe05.GraphSuche.erreichbarkeit(g1, 0, 5));
        sg.start();*/

        sg.step(g1.getAdjazenzmatrix());
        sg.start();
        printDijkstra(dijkstra(g1,0));

    }
}
