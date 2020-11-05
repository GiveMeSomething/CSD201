package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public void traverse(GraphRepMatrix matrix, Vertex root) {
        ArrayList<Vertex> identifier = matrix.identifier;
        if (!identifier.contains(root)) {
            return;
        }

        Queue<Vertex> vertexQueue = new LinkedList<>();
        vertexQueue.add(root);

        while (!vertexQueue.isEmpty()) {
            Vertex head = vertexQueue.poll();
            head.visited = true;
            System.out.print(head.name + " ");
            int currentPos = -1;
            for (int i = 1; i < identifier.size(); i++) {
                if (identifier.get(i) == head) {
                    currentPos = i;
                }
            }

            if (currentPos == -1) {
                continue;
            }

            ArrayList<Integer> connected = matrix.graphMatrix.get(currentPos);
            for (int i = 1; i < connected.size(); i++) {
                if (connected.get(i) == 1 && !matrix.identifier.get(i).visited) {
                    Vertex target = matrix.identifier.get(i);
                    if (!vertexQueue.contains(target)) {
                        vertexQueue.add(target);
                    }
                }
            }
        }

        //check if any vertex not visited
        for (int i = 1; i < identifier.size(); i++) {
            if (!identifier.get(i).visited) {
                traverse(matrix, identifier.get(i));
            }
        }
    }
}
