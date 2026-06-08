package blatt30.aufgabe01;

public class Node <T extends Comparable<T>> {

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node(Node<T> n) {
        this.value = n.value;
        this.left = n.getLeft();
        this.right = n.getRight();
    }

    private Node<T> left;
    private Node<T> right;
    private T value;

    public Node<T> getLeft() {
        return this.left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRight() {
        return this.right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public T getValue() {
        return this.value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public int getChildren() {
        if (this.left == null && this.right == null) {
            return 0;
        } if ((this.left == null) || (this.right == null)) {
            return 1;
        } return 2;
    }

    public Node<T>[] findInOrderNeighbour() {
        if (this.getChildren() == 0) {return new Node[]{null, null};}
        Node<T>[] ans = new Node[2];
        ans[0] = this.left;
        ans[1] = this.right;
        while (ans[0].getLeft() != null || ans[1].getRight() != null) {
            if (ans[0].getRight() != null) {
                ans[0] = ans[0].getRight();
            }
            if (ans[1].getLeft() != null) {
                ans[1] = ans[1].getLeft();
            }
        }
        return ans;
    }
}