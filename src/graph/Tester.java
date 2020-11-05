package graph;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Adjacency Matrix");

        Vertex a = new Vertex(0, "a");
        Vertex b = new Vertex(0, "b");
        Vertex c = new Vertex(0, "c");
        Vertex d = new Vertex(0, "d");
        Vertex e = new Vertex(0, "e");
        Vertex f = new Vertex(0, "f");
        Vertex g = new Vertex(0, "g");

        GraphRepMatrix matrix = new GraphRepMatrix();
        matrix.add(a, b, c, d, e, f, g);
        matrix.display();

        //Test 3
        matrix.connect(a, e, g);
        matrix.connect(b, e, g, c);
        matrix.connect(c, d, f);
        matrix.connect(d, c, f);
        matrix.connect(e, a, b);
        matrix.connect(f, c, d);
        matrix.connect(g, a, b);

        matrix.display();

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.traverse(matrix, a);

//        System.out.println("Adjacency List");
//
//        GraphRepList list = new GraphRepList();
//        list.add(a, b, c, d, e, f, g);
//        list.connect(a, c, f, d);
//        list.connect(b, d, e);
//        list.connect(c, a, f);
//        list.connect(d, a, b, e, f);
//        list.connect(e, b, d);
//        list.connect(f, a, c, d);
//        list.display();
//
//        DepthFirstSearch searcher = new DepthFirstSearch(list);
//        searcher.traverse(a);
    }
}
