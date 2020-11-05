// 
// Decompiled by Procyon v0.5.36
// 

package graph;

import java.util.ArrayList;

public class GraphRepMatrix {
    ArrayList<ArrayList<Integer>> graphMatrix;
    ArrayList<Vertex> identifier;
    public GraphRepMatrix() {
        this.graphMatrix = new ArrayList<>();
        this.identifier = new ArrayList<>();
    }

    public void initMatrix() {
        for (int i = 0; i < this.graphMatrix.size(); ++i) {
            for (int j = 0; j < this.graphMatrix.size(); ++j) {
                this.graphMatrix.get(i).add(0);
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
        this.identifier.add(vertex);
        this.graphMatrix.add(new ArrayList<>());
    }

    public void connect(Vertex a, Vertex... others) {
        for (Vertex vertex : others) {
            this.connect(a, vertex);
        }
    }

    public void connect(Vertex a, Vertex b) {
        int firstPos = -1;
        int secondPos = -1;
        for (int i = 0; i < identifier.size(); ++i) {
            if (firstPos == -1 && identifier.get(i) == a) {
                firstPos = i;
            }
            if (secondPos == -1 && identifier.get(i) == b) {
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
        this.graphMatrix.get(firstPos).set(secondPos, 1);
        this.graphMatrix.get(secondPos).set(firstPos, 1);
    }

    public void display() {
        System.out.println();
        System.out.print("\t");
        for (int i = 0; i < this.identifier.size(); ++i) {
            System.out.print(i + "\t");
        }
        System.out.println();
        for (int i = 0; i < this.identifier.size(); ++i) {
            System.out.print(i + "\t");
            for (int j = 0; j < this.identifier.size(); ++j) {
                System.out.print(this.graphMatrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
