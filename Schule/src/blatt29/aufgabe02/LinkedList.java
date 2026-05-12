package blatt29.aufgabe02;

public class LinkedList<T> {

    private Node<T> head;
    private T value;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public int size() {
        int s = 0;
        Node <T> n = this.head;
        while (n != null) {
            n = n.next();
            s++;
        }
        return s;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        Node <T> n = this.head;
        for (int i = 0; i < index; i++) {
            if (n == null) {
                throw new IndexOutOfBoundsException("LinkedListIndexOutOfBounds");
            }
            n = n.next();
        }
        return n.getValue();
    }

    public boolean contains(T value) {
        Node <T> n = this.head;
        while (n != null) {
            if (n.getValue().equals(value)) {
                return true;
            }
            n = n.next();
        }
        return false;
    }

    public void add(T value) {
        Node <T> newN = new Node<>(value);
        Node <T> n = this.head;
        while (n.next() != null) {
            n = n.next();
        }
        n.setNext(newN);
    }

    public void add(T value, int pos) {
        Node <T> n = this.head;
        Node <T> newN = new Node<>(value);
        for (int i = 0; i < pos - 1; i++) {
            n = n.next();
        }
        newN.setNext(n.next());
        n.setNext(newN);
    }

    public void remove(int pos) {
        Node<T> n = this.head;

        if (pos > 0) {
            for (int i = 0; i < pos - 1; i++) {
                n = n.next();
            }
            n.setNext(n.next().next());
        } else {
            this.head = n.next();
        }
    }

    public void clear() {
        this.head = null;
    }
}
