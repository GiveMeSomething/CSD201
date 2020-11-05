package practice.list;

import java.util.ArrayList;

public class MyLinkedList {
    Node head, tail;
    int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        addFirst(node);
    }

    public void addLast(int value) {
        Node node = new Node(value);
        addLast(node);
    }

    public void addAt(int value, int index) {
        Node node = new Node(value);
        addAt(node, index);
    }

    public void addFirst(Node node) {
        size++;
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void addLast(Node node) {
        size++;
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public void addAt(Node node, int index) {
        if (index > size) {
            return;
        }
        size++;
        Node current = head;
        int counter = 0;
        while (current != null) {
            if (counter == index) {
                node.prev = current.prev;
                node.next = current;
                current.prev.next = node;
                current.prev = node;
                break;
            }
            counter++;
            current = current.next;
        }
    }

    public void invertLast(int number) {
        if (number > size) {
            return;
        }
        ArrayList<Integer> lastElementsValue = new ArrayList<>();
        Node current = tail;
        while (number > 0) {
            lastElementsValue.add(current.value);
            number--;
            current = current.prev;
        }
        if (current == null) {
            current = head;
        } else {
            current = current.next;
        }
        while (current != null) {
            current.value = lastElementsValue.get(number);
            current = current.next;
            number++;
        }
    }

    public void display() {
        if (isEmpty()) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
