package blatt32.aufgabe05;

import blatt28.aufgabe01.Stapel;
import blatt28.aufgabe01.Warteschlange;
import blatt32.augabe03.Graph;

import java.util.Stack;

public class GraphSuche {

    public boolean zyklensuche(Graph g) {
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

    public boolean[] erreichbarkeit(Graph g, int v) {
        Warteschlange<Integer> queue = new Warteschlange<>();
        boolean[] erreichbar = new boolean[g.size()];
        int[][] a = g.getAdjazenzmatrix();

        for (int i = 0; i < erreichbar.length; i++) {
            erreichbar[i] = false;
        }

        erreichbar[v] = true;
        queue.add(v);

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
}

/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// /////////////////////////////////Du hast die Ausgabe vergessen!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//////////////////////////////////////
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
