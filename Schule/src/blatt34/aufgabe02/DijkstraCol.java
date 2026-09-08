package blatt34.aufgabe02;

public class DijkstraCol implements Comparable<DijkstraCol>{
    private int vertex;
    private int from;
    private int distance;
    private int prev;
    private boolean visited;

    public DijkstraCol(int vertex, int from, int distance, int prev, boolean visited) {
        this.vertex = vertex;
        this.from = from;
        this.distance = distance;
        this.prev = prev;
        this.visited = visited;
    }

    public int getVertex() {
        return this.vertex;
    }

    public void setVertex(int vertex) {
        this.vertex = vertex;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int compareTo(DijkstraCol o) {
        if (this.distance < o.distance) {
            return -1;
        }
        if (this.distance > o.distance) {
            return 1;
        }
        return 0;
    }
}
