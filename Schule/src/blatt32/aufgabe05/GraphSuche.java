package blatt32.aufgabe05;

import blatt28.aufgabe01.Stapel;
import blatt28.aufgabe01.Warteschlange;
import blatt32.augabe03.Graph;

public class GraphSuche {

    public static void main(String[] args) {

    }

    public static boolean zyklensuche(Graph g) {
        Stapel<Integer> stack = new Stapel<>();
        boolean zyklus = false;
        int[][] a = g.getAdjazenzmatrix();

        boolean[] visited = new boolean[g.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        visited[0] = true;
        stack.push(0);

        while  (!stack.empty()) {
            int u = stack.pop();
            for(int i = 0; i < a[u].length; i++) {
                if(a[u][i] != 0) {
                    if (visited[i] && !zyklus) {
                        zyklus = true;
                    } else {
                        visited[i] = true;
                        stack.push(i);
                    }
                }
            }
        }

        return zyklus;
    }

    /*TODO: Ausgabe mit schGraphs*/

    public static boolean erreichbarkeit(Graph g, int v) {
        Warteschlange<Integer> queue = new Warteschlange<>();
        boolean[] erreichbar = new boolean[g.size()];
        int[][] a = g.getAdjazenzmatrix();

        for (int i = 0; i < erreichbar.length; i++) {
            erreichbar[i] = false;
        }

        erreichbar[v] = true;
        queue.add(v);

        while  (!queue.empty()) {
            int u = queue.poll();
            for(int i = 0; i < a[u].length; i++) {
                if(a[u][i] != 0) {
                    if (!erreichbar[i]) {
                        queue.add(i);
                        erreichbar[i] = true;
                    }
                }
            }
        }

        for (int i = 0; i < erreichbar.length; i++) {
            if (!erreichbar[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean erreichbarkeit(Graph g, int from, int to) {
        Warteschlange<Integer> queue = new Warteschlange<>();
        boolean[] erreichbar = new boolean[g.size()];
        int[][] a = g.getAdjazenzmatrix();

        for (int i = 0; i < erreichbar.length; i++) {
            erreichbar[i] = false;
        }

        erreichbar[from] = true;
        queue.add(from);

        while  (!queue.empty()) {
            int u = queue.poll();
            for(int i = 0; i < a[u].length; i++) {
                if(a[u][i] != 0) {
                    if (!erreichbar[i]) {
                        queue.add(i);
                        erreichbar[i] = true;
                    }
                }
            }
        }

        return erreichbar[to];
    }
}