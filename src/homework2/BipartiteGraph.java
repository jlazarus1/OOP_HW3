package homework2;

import java.util.ArrayList;

public class BipartiteGraph<T> {

    private ArrayList<Vertex<T>> blackVertices;
    private ArrayList<Vertex<T>> whiteVertices;
    private ArrayList<Edege<T>> edges;

    public BipartiteGraph() {
        blackVertices = new ArrayList<Vertex<T>>();
        whiteVertices = new ArrayList<Vertex<T>>();
        edges = new ArrayList<Edege<T>>();
    }


}
