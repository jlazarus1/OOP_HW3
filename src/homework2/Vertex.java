package homework2;

import java.util.ArrayList;

/**
 *
 * this class represents a "shell" of each node in the graph
 *
 */

public class Vertex<T> {

    private T label;
    private Object actualNode = null;
    private boolean isVertexWhite;
    private ArrayList<Vertex<T>> parents;
    private ArrayList<Vertex<T>> children;

    /*
     * @Requires label != null
     * @modifies this
     * @effects constructs a new empty shell vertex (only with a label)
     */
    public Vertex(T label, boolean isWhite) {
        this.label = label;
        this.isVertexWhite = isWhite;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();;
    }
    /*
     * @Requires label != null
     * @modifies this
     * @effects constructs a new non empty shell vertex (includes another class)
     */
    public Vertex(T label, boolean isWhite , Object nodeType){
        this.label = label;
        this.isVertexWhite = isWhite;
        this.actualNode = nodeType;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();;
    }


    /*
     *  @modifies - user may modify object
     *  @returns the actual representation of the vertex
     */
    public Object getActualNode(){
        return actualNode;
    }

    /*
     * @returns the label of the vertex
     */
    public T getLabel(){
        return label;
    }


    /*
     * @modifies this
     * @effects adds a parent to this vertex
     */
    public void addParent(Vertex<T> parent){
        this.parents.add(parent);
    }


    /*
     * @requires child != null
     * @modifies this
     * @effects adds a child to this vertex
     */
    public void addChild(Vertex<T> child){
        this.children.add(child);
    }


    /*
     * @returns an array of children vertices
     */
    public ArrayList<Vertex<T>> getChildren(){
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(children);
        return ret;
    }


    /*
     * @returns an array of parents vertices
     */
    public ArrayList<Vertex<T>> getParents(){
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(parents);
        return ret;
    }
    public boolean getIsVertexWhite(){
        return isVertexWhite;
    }

    public void removeChild(Vertex<T> child){
        for(Vertex<T> i : children){
            if(i.getLabel().equals(child.getLabel())){
                children.remove(i);
            }
        }
    }
    public void removeParent(Vertex<T> parent){
        for(Vertex<T> i : parents){
            if(i.getLabel().equals(parent.getLabel())){
                children.remove(i);
            }
        }
    }

}
