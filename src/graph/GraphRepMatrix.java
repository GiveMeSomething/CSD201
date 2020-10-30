// 
// Decompiled by Procyon v0.5.36
// 

package graph;

import java.util.ArrayList;

public class GraphRepMatrix {
    ArrayList<ArrayList<Vertex>> graphMatrix;

    public GraphRepMatrix() {
        this.graphMatrix = new ArrayList<>();
        this.graphMatrix.add(new ArrayList<>());
        this.graphMatrix.get(0).add(new Vertex(Integer.MAX_VALUE));
    }

    public void initMatrix() {
        for (int i = 1; i < this.graphMatrix.size(); ++i) {
            for (int j = 1; j < this.graphMatrix.size(); ++j) {
                this.graphMatrix.get(i).add(new Vertex(0));
            }
        }
    }

    public void add(Vertex... vertices) {
        for (Vertex vertex : vertices) {
            this.add(vertex);
        }
        this.initMatrix();
    }

    public void add(Vertex vertex) {
        this.graphMatrix.get(0).add(vertex);
        this.graphMatrix.add(new ArrayList<>());
        int size = this.graphMatrix.size() - 1;
        this.graphMatrix.get(size).add(vertex);
    }

    public void connect(Vertex a, Vertex... others) {
        for (Vertex vertex : others) {
            this.connect(a, vertex);
        }
    }

    public void connect(Vertex a, Vertex b) {
        int firstPos = -1;
        int secondPos = -1;
        ArrayList<Vertex> identifier = this.graphMatrix.get(0);
        for (int i = 1; i < identifier.size(); ++i) {
            if (identifier.get(i) == a) {
                firstPos = i;
            }
            if (identifier.get(i) == b) {
                secondPos = i;
            }
            if (firstPos != -1 && secondPos != -1) {
                break;
            }
        }
        if (firstPos == -1 || secondPos == -1) {
            System.out.println("Can't connect");
            return;
        }
        this.graphMatrix.get(firstPos).set(secondPos, new Vertex(1));
        this.graphMatrix.get(secondPos).set(firstPos, new Vertex(1));
    }

    public void display() {
        System.out.println();
        System.out.print("\t");
        for (int i = 1; i < this.graphMatrix.get(0).size(); ++i) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 1; i < this.graphMatrix.get(0).size(); ++i) {
            System.out.print(i + "\t");
            for (int j = 1; j < this.graphMatrix.get(0).size(); ++j) {
                System.out.print(this.graphMatrix.get(i).get(j).value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
