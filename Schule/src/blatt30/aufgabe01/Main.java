package blatt30.aufgabe01;

public class Main {

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<>();
        t.add(new Node<>(10));
        t.add(new Node<>(7));
        t.add(new Node<>(777));
        t.add(new Node<>(9));
        t.add(new Node<>(4));
        t.printInOrder(t.getRoot());
        System.out.println("-------");
        t.remove(9);
        System.out.println("-------");
        t.printInOrder(t.getRoot());
        Node<Integer> a = new Node<>(10);
        Node<Integer> b = new Node<>(7);
        System.out.println("" + a.getValue().compareTo(b.getValue()));
    }
}
