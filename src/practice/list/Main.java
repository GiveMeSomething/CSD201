package practice.list;

public class Main {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.addFirst(5);
        mll.addFirst(4);
        mll.addFirst(3);
        mll.addFirst(4);
        mll.addFirst(2);
        mll.addFirst(1);
        mll.display();
        mll.addAt(10, 1);
        mll.display();
        mll.invertLast(mll.size);
        mll.display();
    }
}
