package blatt29.aufgabe01;

public class LinkedList<T> {

    private Node<T> head;
    private T value;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public int size() {
        int s = 0;
        Node <T> n = head;
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
        Node <T> n = head;
        while (n != null) {

            n = n.next();
        }
    }
}
