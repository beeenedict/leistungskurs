package blatt30.aufgabe01;

public class AVLTree <T extends Comparable<T>> extends Tree<T> {

    public Node<T> getParent(Node<T> n) {
        Node<T> p = null;
        Node<T> t = this.getRoot();

        while (t != n) {
            if (n.getValue().compareTo(t.getValue()) > 0) {
                p = t;
                t = t.getRight();
            } else if (n.getValue().compareTo(t.getValue()) < 0) {
                p = t;
                t = t.getLeft();
            } else {
                break;
            }
        }
        return p;
    }

    public int balance(Node<T> n) {
        return depth(n.getRight()) - depth(n.getLeft());
    }

    public void links(Node<T> n) {
        Node<T> p = this.getParent(n);
        if (p == null) return;
        p.setRight(n.getRight());
        n.setRight(p.getRight().getLeft());
        p.getRight().setLeft(n);
    }

    public void rechts(Node<T> n) {
        Node<T> p = this.getParent(n);
        if (p == null) return;
        p.setLeft(n.getLeft());
        n.setLeft(p.getLeft().getRight());
        p.getLeft().setRight(n);
    }
}