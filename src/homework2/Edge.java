package homework2;

import java.util.ArrayList;

/**
 *
 * represents an edge in the graph
 */
public class Edge<T>  {
    private T lable;
    private Vertex<T> parent;
    private Vertex<T> child;

    /*
     * @requires label & parent & child != null
     * @modifies this.
     * @effects creates a new edge with parent and child
     */
    public Edge(T lable , Vertex<T> parent , Vertex<T> child){
        this.lable = lable;
        this.parent = parent;
        this.child = child;
    }
    /*
     * @returns parent's Vertex
     */
    public Vertex<T> getParent(){
        return parent;
    }
    /*
     * @returns child's Vertex
     */
    public Vertex<T> getChild(){
        return child;
    }
    /*
     * @returns edge label
     */
    public T getLable(){
        return lable;
    }

}
