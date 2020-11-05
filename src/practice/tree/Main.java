package practice.tree;

public class Main {
    public static void main(String[] args) {
        MyTree mt = new MyTree();
        mt.add(1);
        mt.add(2);
        mt.add(3);
        mt.add(4);
        mt.add(5);
        mt.inOrder(mt.root);
    }
}
