package graph;

import java.util.ArrayList;
import java.util.Collections;

public class Vertex
{
    int value;
    String name;
    boolean visited;
    ArrayList<Vertex> connection;
    
    public Vertex(final int value) {
        this.value = value;
        this.visited = false;
        this.connection = new ArrayList<>();
    }
    
    public Vertex(final int value, final String name) {
        this.value = value;
        this.name = name;
        this.visited = false;
        this.connection = new ArrayList<>();
    }
    
    public void addConnection(Vertex... vertices) {
        Collections.addAll(this.connection, vertices);
    }
}
