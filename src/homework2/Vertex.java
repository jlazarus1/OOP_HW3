package homework2;

import java.util.ArrayList;

/**
 * this class represents a "shell" of each node in the graph
 */

public class Vertex<T> {

    private T label;
    private Object actualNode = null;
    private boolean isVertexWhite;
    private ArrayList<Vertex<T>> parents;
    private ArrayList<Vertex<T>> children;

    /*
     * @ requires label must be immutable and override equals
     * @ modifies this
     * @ effects creates a vertex with label and if its  white.
     */
    public Vertex(T label, boolean isWhite) throws NullPointerException {
        if (label == null) throw new NullPointerException();
        this.label = label;
        this.isVertexWhite = isWhite;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();
        ;
    }

    /*
     * @ requires label must be immutable and override equals
     * @ modifies this
     * @ effects creates a vertex with label and if its  white with object nodeType
     *  throws exception if nodeType or label are null
     */
    public Vertex(T label, boolean isWhite, Object nodeType) throws NullPointerException {
        if (label == null || nodeType == null) throw new NullPointerException();
        this.label = label;
        this.isVertexWhite = isWhite;
        this.actualNode = nodeType;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();
        ;
    }


    /*
     * @ effects returns the actual node
     */
    public Object getActualNode() {
        return actualNode;
    }

    /*
     * @ effects returns the label
     */
    public T getLabel() {
        return label;
    }

    /*
     * @ effects adds parent as a parent
     * throws exception if parent is null
     */
    public void addParent(Vertex<T> parent) throws NullPointerException {
        if (parent == null) throw new NullPointerException();
        this.parents.add(parent);
    }

    /*
     * @ effects adds child as child
     * throws exception if parent is null
     */
    public void addChild(Vertex<T> child) throws NullPointerException {
        if (child == null) throw new NullPointerException();
        this.children.add(child);
    }

    /*
     * @effects gets list of children from vertex
     */
    public ArrayList<Vertex<T>> getChildren() {
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(children);
        return ret;
    }


    /*
     * @effects gets list of parents from vertex
     */

    public ArrayList<Vertex<T>> getParents() {
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(parents);
        return ret;
    }

    //@effects returns if vertex is white
    public boolean getIsVertexWhite() {
        return isVertexWhite;
    }

    /*
    @modifies this
    @effects removes the child from vertex
    throws exception if child is null
     */
    public void removeChild(Vertex<T> child) throws NullPointerException {
        if (child == null) throw new NullPointerException();
        for (Vertex<T> i : children) {
            if (i.getLabel().equals(child.getLabel())) {
                children.remove(i);
            }
        }
    }

    /*
 @modifies this
 @effects removes the parent from vertex
 throws exception if parent is null
  */
    public void removeParent(Vertex<T> parent) throws NullPointerException {
        if (parent == null) throw new NullPointerException();
        for (Vertex<T> i : parents) {
            if (i.getLabel().equals(parent.getLabel())) {
                children.remove(i);
            }
        }
    }

}
