package practice.tree;

import java.util.Collections;

public class MyTree {
    Node root;

    public MyTree() {
        root = null;
    }

    public void add(int value) {
        if (isEmpty()) {
            root = new Node(value);
            return;
        }
        add(root, value);
    }

    public Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value > current.value) {
            current.right = add(current.right, value);
        } else if (value < current.value) {
            current.left = add(current.left, value);
        } else {
            return current;
        }
        return current;
        //return null de co the lay vi tri bi trung
    }

    public void inOrder(Node current) {
        if (current == null) {
            return;
        }

        inOrder(current.left);
        System.out.print(current.value + " ");
        inOrder(current.right);
    }

    public boolean isEmpty() {
        return root == null;
    }
}
