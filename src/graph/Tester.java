package graph;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Adjacency Matrix");
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(0);
        Vertex c = new Vertex(0);
        Vertex d = new Vertex(0);
        Vertex e = new Vertex(0);
        Vertex f = new Vertex(0);
        Vertex g = new Vertex(0);

        GraphRepMatrix matrix = new GraphRepMatrix();
        matrix.add(a, b, c, d, e, f, g);
        matrix.display();
        matrix.connect(a, c, f, d);
        matrix.connect(b, d, e);
        matrix.connect(c, a, f);
        matrix.connect(d, a, b, e, f);
        matrix.connect(e, b, d);
        matrix.connect(f, a, c, d);
        matrix.display();

        System.out.println("Adjacency Matrix");
        a = new Vertex(0, "a");
        b = new Vertex(0, "b");
        c = new Vertex(0, "c");
        d = new Vertex(0, "d");
        e = new Vertex(0, "e");
        f = new Vertex(0, "f");
        g = new Vertex(0, "g");
        GraphRepList list = new GraphRepList();
        list.add(a, b, c, d, e, f, g);
        list.connect(a, c, f, d);
        list.connect(b, d, e);
        list.connect(c, a, f);
        list.connect(d, a, b, e, f);
        list.connect(e, b, d);
        list.connect(f, a, c, d);
        list.display();
    }
}
