package blatt29.aufgabe02;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.next = null;
        this.value = value;
    }

    public Node<T> next() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }
}
