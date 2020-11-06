package graph;

import java.util.ArrayList;
import java.util.Collections;

public class Vertex
{
    int value;
    String name;
    boolean visited;
    ArrayList<Vertex> connection;
    Vertex pre = null;
    
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPre() {
        return pre;
    }

    public void setPre(Vertex pre) {
        this.pre = pre;
    }
}
