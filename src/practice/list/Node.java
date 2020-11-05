package practice.list;

public class Node {
    int value;
    Node prev, next;

    public Node(int value) {
        this.value = value;
        prev = next = null;
    }
}
