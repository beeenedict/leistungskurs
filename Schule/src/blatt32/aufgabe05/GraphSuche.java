package blatt32.aufgabe05;

import blatt28.aufgabe01.Stapel;
import blatt32.augabe03.Graph;

import java.util.Stack;

public class GraphSuche {

    public boolean zyklensuche(Graph g) {
        Stapel<Integer> stack = new Stapel<>();

        boolean[] visited = new boolean[g.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        visited[0] = true;
        stack.push(0);
    }
}
