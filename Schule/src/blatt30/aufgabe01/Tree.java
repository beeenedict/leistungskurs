package blatt30.aufgabe01;

public class Tree <T extends Comparable<T>> {

    private Node <T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node <T> root) {
        this.root = root;
    }

    public void add(Node<T> n) {
        Node<T> t = root;
        while (t != null) {
            if (t.getValue().compareTo(n.getValue()) < 0) {
                if (t.getRight() == null) {
                    t.setRight(n);
                    return;
                } else {
                    t = t.getRight();
                }
            } else {
                if (t.getLeft() == null) {
                    t.setLeft(n);
                    return;
                } else {
                    t = t.getLeft();
                }
            }
        } this.root = n;
    }

    public Node <T> search(T value) {
        Node<T> t = root;
        while (t != null) {
            if (t.getValue().compareTo(value) > 0) {
                t = t.getRight();
            } else if (t.getValue().compareTo(value) < 0) {
                t = t.getLeft();
            } else {
                return t;
            }
        } return t;
    }

    public int depth(Node<T> n) {
        if (n.getRight() != null && n.getLeft() != null) {
            return 1 + Math.max(depth(n.getRight()), depth(n.getLeft()));
        } if (n.getLeft() != null) {
            return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
        } if (n.getRight() != null) {
            return 1 + Math.max(depth(n.getRight()), depth(n.getLeft()));
        } return 1;
    }

    public int count(Node<T> n) {
        if (n.getRight() != null && n.getLeft() != null) {
            return 1 + count(n.getRight()) + count(n.getLeft());
        } if (n.getLeft() != null) {
            return 1 + count(n.getLeft());
        } if (n.getRight() != null) {
            return 1 + count(n.getRight());
        } return 1;
    }

    public Node<T> remove(T value) {
        Node<T> n = this.root;
        System.out.println(n.getValue());
        Node<T> p = null;
        int c;

        while (n != null) {
            if (n.getValue().compareTo(value) < 0) {
                p = n;
                n = n.getRight();
            } else if (n.getValue().compareTo(value) > 0) {
                p = n;
                n = n.getLeft();
            } else {
                break;
            }
        }
        assert n != null;
        c = n.getChildren();
        if (p != null) {
            if (c <= 1) {
                if (p.getRight() == n) {
                    p.setRight(null);
                    if (n.getLeft() != null) {
                        p.setRight(n.getLeft());
                    }
                    if (n.getRight() != null) {
                        p.setRight(n.getRight());
                    }
                } else {
                    p.setLeft(null);
                    if (n.getLeft() != null) {
                        p.setLeft(n.getLeft());
                    }
                    if (n.getRight() != null) {
                        p.setLeft(n.getRight());
                    }
                }
            } else {
                Node<T>[] t = n.findInOrderNeighbour();
                remove(t[1].getValue());
                if (p.getRight() == n) {
                    p.setRight(t[1]);
                } else {
                    p.setLeft(t[1]);
                }
                t[1].setLeft(n.getLeft());
                t[1].setRight(n.getRight());
            }
        } else {
            if (c == 0) {
                this.root = null;
            } if (c == 1) {
                if (n.getLeft() != null) {
                    this.root = n.getLeft();
                } else {
                    this.root = n.getRight();
                }
            } if (c == 2) {
                Node<T>[] t = n.findInOrderNeighbour();
                System.out.println(n.getValue());
                remove(t[1].getValue());
                this.root.setValue(t[1].getValue());
                this.root.setLeft(n.getLeft());
                this.root.setRight(n.getRight());
            }
        }
        return n;
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void printPreOrder(Node<T> n) {
        assert n != null;
        System.out.println(n.getValue());
        if (n.getLeft() != null) {
            printPreOrder(n.getLeft());
        }
        if (n.getRight() != null) {
            printPreOrder(n.getRight());
        }
    }

    public void printInOrder(Node<T> n) {
        assert n != null;
        if (n.getLeft() != null) {
            printInOrder(n.getLeft());
        }
        System.out.println(n.getValue());
        if (n.getRight() != null) {
            printInOrder(n.getRight());
        }
    }

    public void printPostOrder(Node<T> n) {
        assert n != null;
        if (n.getLeft() != null) {
            printPostOrder(n.getLeft());
        }
        if (n.getRight() != null) {
            printPostOrder(n.getRight());
        }
        System.out.println(n.getValue());
    }
}