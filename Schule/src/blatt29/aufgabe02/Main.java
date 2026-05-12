package blatt29.aufgabe02;

public class Main {

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        LinkedList<Integer> list = new LinkedList<>(head);

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(0, 5);
        if (list.contains(5)) {
            list.remove(0);
        }
        System.out.println("size: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}