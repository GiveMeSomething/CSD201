package graph;

import java.util.Collections;
import java.util.ArrayList;

public class GraphRepList {
    ArrayList<Vertex> vertexList;

    public GraphRepList() {
        this.vertexList = new ArrayList<>();
    }

    public void add(final Vertex... vertices) {
        Collections.addAll(this.vertexList, vertices);
    }

    public void connect(final Vertex a, final Vertex... others) {
        if (!this.vertexList.contains(a)) {
            System.out.println("Not exist");
            return;
        }
        a.addConnection(others);
    }

    public void display() {
        System.out.println();
        for (int i = 0; i < this.vertexList.size(); ++i) {
            Vertex current = this.vertexList.get(i);
            System.out.print(current.name + ":\t");
            for (int j = 0; j < current.connection.size(); ++j) {
                System.out.print(current.connection.get(j).name + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
