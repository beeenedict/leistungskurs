package blatt34.aufgabe02;

import blatt32.augabe03.Edge;
import blatt32.augabe03.Graph;

import java.util.ArrayList;

import static blatt32.aufgabe05.GraphSuche.erreichbarkeit;

public class Dijkstra {



    public static Dijkstra[] dijkstra(Graph g, int start) {

        if (!erreichbarkeit(g, start)) {
            return null;
        }

        int s = g.size();
        int[][] adjM = g.getAdjazenzmatrix();
        ArrayList<DijkstraCol> table = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            table.add(new DijkstraCol(i, start, Integer.MAX_VALUE, null, false));
        }
        table.getFirst().setDistance(0);

        do {
            table.sort(null);
            DijkstraCol currentV = null;

            for (DijkstraCol v : table) {
                if (!v.isVisited()) {
                    currentV = v;
                    v.setVisited(true);
                    break;
                }
            }

            assert currentV != null;
            Edge[] edges = g.getKanten(currentV.getVertex());

            for (Edge e : edges) {
                int index = -1;
                for (int i = 0; i < table.size(); i++) {
                    if(table.get(i).getVertex() == e.getTo()) {
                        index = i;
                    }
                }
                if (currentV.getDistance() + e.getWeight() < table.get(index).getDistance()) {
                    table.get(index).setDistance(currentV.getDistance() + e.getWeight());
                    table.get(index).setPrev(currentV);
                }
            }
        } while (true);
    }
}
