package blatt32.augabe03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {

    private int[][] adjazenzmatrix = new int[][]{};

    public Graph(int v) {
        this.adjazenzmatrix = new int[v][v];
    }

    public void addVertex() {
        int[][] newGraph = new int[adjazenzmatrix.length + 1][adjazenzmatrix[0].length + 1];

        for (int i = 0; i < adjazenzmatrix.length; i++) {
            for (int j = 0; j < adjazenzmatrix[0].length; j++) {
                newGraph[i][j] = this.adjazenzmatrix[i][j];
            }
        }

        for (int i = 0; i < newGraph.length; i++) {
            newGraph[i][adjazenzmatrix.length] = 0;
            newGraph[adjazenzmatrix.length][i] = 0;
        }

        this.adjazenzmatrix = newGraph;
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1, false);
    }

    public void addEdge(int from, int to, boolean isDirected) {
        addEdge(from, to, 1, isDirected);
    }

    public void addEdge(int from, int to, int weight) {
        addEdge(from, to, weight, false);
    }

    public void addEdge(int from, int to, int weight, boolean isDirected) {

        if (from > this.adjazenzmatrix.length - 1 || to > this.adjazenzmatrix.length - 1 || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }

        this.adjazenzmatrix[from][to] = weight;
        if (!isDirected) {
            this.adjazenzmatrix[to][from] = weight;
        }
    }

    public int size() {
        return this.adjazenzmatrix.length;
    }

    public boolean isWeighted() {
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = 0; j < this.adjazenzmatrix[0].length; j++) {
                if (this.adjazenzmatrix[i][j] != 1 && this.adjazenzmatrix[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDirected() {
        for (int i = 0; i < this.adjazenzmatrix.length; i++) {
            for (int j = 0; j < this.adjazenzmatrix[0].length; j++) {
                if (this.adjazenzmatrix[i][j] != this.adjazenzmatrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*TODO:getNeighbours */

    public int[][] getAdjazenzmatrix() {
        return blatt14.MultiArrays.copy2DintArray(this.adjazenzmatrix);
    }

    public int[] getNeighbours(int v) {
        ArrayList<Integer> neighboursList = new ArrayList<Integer>();

        for (int i = 0; i < this.adjazenzmatrix[v].length; i++) {
            if (this.adjazenzmatrix[v][i] != 0) {
                neighboursList.add(i);
            }
        }

        int[] neighbours = new int[neighboursList.size()];
        for (int i = 0; i < neighboursList.size(); i++) {
            neighbours[i] = neighboursList.get(i);
        }

        return neighbours;
    }

    public void exportGraph() {
        char sep = File.separatorChar;
        try {
            File dir = new File("Schule" + sep + "io");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File f = new File(dir.getPath() + sep + "adjazenzmatrix.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("" + this.adjazenzmatrix.length);
            bfw.newLine();
            for (int i = 0; i < this.adjazenzmatrix.length; i++) {
                for (int j = 0; j < this.adjazenzmatrix[0].length; j++) {
                    bfw.write(this.adjazenzmatrix[i][j] + "");
                    bfw.newLine();
                }
            }
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
