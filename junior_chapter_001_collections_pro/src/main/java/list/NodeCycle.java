package list;

public class NodeCycle {
    boolean hasCycle(Node node) {
        Node turtle = node;
        Node hare = node;
        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle == hare) {
                return true;
            }
        }
        return false;
    }

}


class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}

