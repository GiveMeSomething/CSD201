package graph.shortestPath;

import graph.GraphRepMatrix;
import graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DijkstraAlgorithm {
    GraphRepMatrix matrix;
    ArrayList<ArrayList<Integer>> matrixGraph;
    ArrayList<Vertex> identifier;

    public DijkstraAlgorithm(GraphRepMatrix matrix) {
        this.matrix = matrix;
        this.matrixGraph = matrix.graphMatrix;
        this.identifier = matrix.identifier;
        resetVertex();
    }

    public void findPath(Vertex start) {
        if (!identifier.contains(start)) {
            return;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < identifier.size(); i++) {
            result.add(Integer.MAX_VALUE);
        }
        ArrayList<Vertex> toBeChecked = new ArrayList<>();
        int currentPos = -1;
        for (int i = 0; i < identifier.size(); i++) {
            if (identifier.get(i) == start) {
                currentPos = i;
                continue;
            }
            toBeChecked.add(identifier.get(i));
        }
        result.set(currentPos, 0);

        Queue<Vertex> remaining = new LinkedList<>();
        remaining.add(identifier.get(currentPos));

        while(!remaining.isEmpty()) {
            currentPos = identifier.indexOf(remaining.poll());
            identifier.get(currentPos).setVisited(true);

            for (int i = 0; i < matrixGraph.get(currentPos).size(); i++) {
                int current = matrixGraph.get(currentPos).get(i);
                if (current != -1) {
                    remaining.add(identifier.get(i));
                    if (result.get(i) > result.get(currentPos) + matrixGraph.get(currentPos).get(i)) {
                        result.set(i, result.get(currentPos) + matrixGraph.get(currentPos).get(i));
                    }
                }
            }
            if (check()) {
                break;
            }
        }

        System.out.println(result);
    }

    public void resetVertex() {
        ArrayList<Vertex> identifier = matrix.identifier;
        for (Vertex vertex : identifier) {
            vertex.setVisited(false);
        }
    }

    public boolean check(){
        for (Vertex vertex : identifier) {
            if (!vertex.isVisited()) {
                return false;
            }
        }
        return true;
    }

    public void display(ArrayList<Vertex> identifier, ArrayList<Integer> result) {
        for (Vertex vertex : identifier) {
            System.out.print(vertex.getName() + "\t");
        }
        System.out.println();
        for (Integer value : result) {
            System.out.print(value + "\t");
        }
    }
}
