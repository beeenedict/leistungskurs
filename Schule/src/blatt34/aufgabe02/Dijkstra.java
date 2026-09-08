package blatt34.aufgabe02;

import blatt32.augabe03.Edge;
import blatt32.augabe03.Graph;

import java.util.ArrayList;

import static blatt32.aufgabe05.GraphSuche.erreichbarkeit;

public class Dijkstra {

    public static DijkstraCol[] dijkstra(Graph g, int start) {

        if (!erreichbarkeit(g, start)) {
            return null;
        }

        int s = g.size();
        int[][] adjM = g.getAdjazenzmatrix();
        ArrayList<DijkstraCol> table = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            table.add(new DijkstraCol(i, start, Integer.MAX_VALUE, -1, false));
        }
        table.get(start).setDistance(0);
        table.get(start).setPrev(start);

        DijkstraCol currentV;

        do {
            table.sort(null);
            currentV = null;

            for (DijkstraCol v : table) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    currentV = v;
                    break;
                }
            }

            if (currentV != null) {
                Edge[] edges = g.getKanten(currentV.getVertex());

                for (Edge e : edges) {
                    int index = -1;
                    for (int i = 0; i < s; i++) {
                        if (table.get(i).getVertex() == e.getTo() && !table.get(i).isVisited()) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        continue;
                    }
                    if (currentV.getDistance() + e.getWeight() < table.get(index).getDistance()) {
                        table.get(index).setDistance(currentV.getDistance() + e.getWeight());
                        table.get(index).setPrev(currentV.getVertex());

                    }
                }
            }
        } while (currentV != null);

        return table.toArray(new DijkstraCol[0]);
    }

    public static void printDijkstra(DijkstraCol[] dijkstra) {
        for (DijkstraCol v : dijkstra) {
            System.out.print(v.getVertex() + " |\t");
        }
        System.out.println();
        for (DijkstraCol v : dijkstra) {
            System.out.print(v.getDistance() + " | ");
        }
        System.out.println();
        for (DijkstraCol v : dijkstra) {
            System.out.print(v.getPrev() + " |\t");
        }
    }
}
