package blatt32.augabe06;

import blatt28.aufgabe01.Stapel;
import blatt32.augabe03.Edge;
import blatt32.augabe03.Graph;
import schgraphs.SchGraphs;

import java.util.ArrayList;

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

    public static Graph primMST(Graph g, int start) {
        SchGraphs sg = new SchGraphs();
        Graph mst = new Graph(g.size());
        int size = g.size();

        boolean[] visited = new boolean[size];
        visited[start] = true;

        ArrayList<Edge> edges = new ArrayList<>();

        do {
            edges.clear();
            for (int i = 0; i < size; i++) {
                if (visited[i]) {
                    for (int j = 0; j < g.size(); j++) {
                        int e = g.getAdjazenzmatrix()[i][j];
                        if (e > 0 && !visited[j]) {
                            edges.add(new Edge(i, j, e));
                        }
                    }
                }
            }
            edges.sort(null);
            if (!edges.isEmpty()) {
                Edge chosen = edges.removeFirst();
                visited[chosen.getTo()] = true;
                mst.addEdge(chosen.getFrom(), chosen.getTo(), chosen.getWeight());
                sg.step(mst.getAdjazenzmatrix());
            }
        } while (!edges.isEmpty());

        sg.start();
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
            }
        }

        sg.start();
        return mst;
    }


}
