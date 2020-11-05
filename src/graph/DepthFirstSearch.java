package graph;

import java.util.ArrayList;

public class DepthFirstSearch {
    ArrayList<Vertex> vertices = new ArrayList<>();
    GraphRepList input;

    public DepthFirstSearch(GraphRepList input) {
        this.input = input;
    }

    public void traverse(Vertex current){
        System.out.print(current.name + " ");
        current.visited = true;
        if (!current.connection.isEmpty()) {
            for (Vertex vertex : current.connection) {
                if(!vertex.visited){
                    traverse(vertex);
                    break;
                }
            }
        }

        for(Vertex vertex: input.vertexList){
            if(!vertex.visited){
                traverse(vertex);
            }
        }
    }
}
