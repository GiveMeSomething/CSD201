package graph;

import graph.shortestPath.DijkstraAlgorithm;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Adjacency Matrix");

        Vertex a = new Vertex(0, "a");
        Vertex b = new Vertex(0, "b");
        Vertex c = new Vertex(0, "c");
        Vertex d = new Vertex(0, "d");
        Vertex e = new Vertex(0, "e");
        Vertex f = new Vertex(0, "f");

        GraphRepMatrix matrix = new GraphRepMatrix();
        matrix.add(a, b, c, d, e, f);
        matrix.display();


//        System.out.println("Representation Start Here (Matrix)");
//        //Test 3
//        matrix.connect(a, e, g);
//        matrix.connect(b, e, g, c);
//        matrix.connect(c, d, f);
//        matrix.connect(d, c, f);
//        matrix.connect(e, a, b);
//        matrix.connect(f, c, d);
//        matrix.connect(g, a, b);
//
//        matrix.display();
//
//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//        bfs.traverse(matrix, a);


        System.out.println("Dijkstra Test Start Here");
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(matrix);
        //setup connection for weighted graph
        matrix.connect(a, b, 14);
        matrix.connect(a, c, 9);
        matrix.connect(a, d, 1);
        matrix.connect(b, c, 2);
        matrix.connect(b, e, 9);
        matrix.connect(c, d, 10);
        matrix.connect(c, f, 11);
        matrix.connect(d, f, 15);
        matrix.connect(e, f, 6);

        matrix.display();

        dijkstra.findPath(a);


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
