package blatt32.augabe06;

import blatt32.augabe03.Edge;
import blatt32.augabe03.Graph;
import schgraphs.SchGraphs;

import static blatt32.aufgabe05.GraphSuche.erreichbarkeit;

public class MST {

    public static void swap(Edge[] arr, int a, int b) {
        Edge temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sortEdges(Edge[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static Graph primMST(Graph g) {
        Graph mst = new Graph(g.size());



        return mst;
    }

    public static Graph kruskalMST(Graph g) {
        SchGraphs sg = new SchGraphs();
        Graph mst = new Graph(g.size());

        Edge[] edges = g.getKanten();
        sortEdges(edges);

        for (int i = 0; i < edges.length; i++) {
            if (!erreichbarkeit(mst, edges[i].getFrom(), edges[i].getTo())) {
                mst.addEdge(edges[i].getFrom(), edges[i].getTo(), edges[i].getWeight());
                sg.step(mst.getAdjazenzmatrix());
                System.out.println("eeeh");
            }
        }

        sg.start();
        return mst;
    }


}
