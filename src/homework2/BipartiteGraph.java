package homework2;





/*
This class Implements a generic Bipartite Graph. The nodes and Vertexes may be of any class.



 */

import java.util.ArrayList;
import java.util.Collections;


public class BipartiteGraph<T> {
    // Representation Invariant - BipartiteGraph must be != null must not have edges that are not connected to either father or child.

    private ArrayList<Vertex<T>> blackVertices;
    private ArrayList<Vertex<T>> whiteVertices;
    private ArrayList<Edge<T>> edges;


    /*
     * @requires type must be a type that is immutable and has an overridden equals method
     * @ modifies this.
     * @effects creates a new graph with graphLabel as its Label. if graphLabel is null, throws exception
     */

    public BipartiteGraph() {
        blackVertices = new ArrayList<Vertex<T>>();
        whiteVertices = new ArrayList<Vertex<T>>();
        edges = new ArrayList<Edge<T>>();
    }


    /*
    *  @requires T must have an overridden equals method
    * @modifies this.
    * @effects creates a graph with a black node with nodeLabel as label.
    * if nodeLabel == null, will throw exception.
    *
     */
    public void addBlackNode(T nodeLabel) throws NullPointerException
    {

        checkRep();
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert= new Vertex<T>(nodeLabel, false);
        blackVertices.add(vert);
        checkRep();
    }


    /*
     *@requires  type T must have an overridden equals method
     * @modifies this.
     * @effects creates a graph with a black node with nodeLabel as label.
     * if nodeLabel == null, will throw exception.
     *
     */
    public void addWhiteNode(T nodeLabel) throws NullPointerException
    {
        checkRep();
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert = new Vertex<T>(nodeLabel, true);
        whiteVertices.add(vert);
        checkRep();

    }



    /*
    * @requires nothing
    * @ returns reference to the vertex of contained label. if no vertex is found, returns null
     */

    private Vertex<T> findLabel(T label) throws  NullPointerException{

        if (label == null) throw new NullPointerException();
        for (Vertex<T> i : blackVertices)
            if(i.getLable().equals(label)) return i;

        for (Vertex<T> i : whiteVertices)
            if(i.getLable().equals(label))return i;

        return null;

    }






    /*
    *@requires T must be immutable and have an overridden equals method
    *@ modifies this.
    *@effects adds an edge to a specific graph at a specific point. if one of the
    *         labels is null or non existent, throws an exception
    *
    *
     */





    public boolean addEdge(T parentLabel, T childLabel, T edgeLabel) throws NullPointerException{
        checkRep();
        if (parentLabel ==null || childLabel == null || edgeLabel == null) throw new NullPointerException();
        Vertex<T> parent = findLabel(parentLabel);
        Vertex<T> child = findLabel(childLabel);

        // check if the parent and child labels exist in the graph
        if (parent == null || child == null) return  false;

        // check if both parent and child are white, if so you may not connect them
        if (parent.getIsVertexWhite() == child.getIsVertexWhite()) return false;

        parent.addChild(child);
        child.addParent(parent);

        Edge edge = new Edge(edgeLabel , parent , child);
        edges.add(edge);
        checkRep();
        return true;



    }

    /*
    *@requires T must be immutable and have an overridden equals method
    *@modifies nothing.
    *@effects returns an ArrayList of type T with all the elements of black nodes from the graph. holds the reference to the objects themselves
    *@returns an array list with references to the black nodes in graph.
     */

    public ArrayList<T> listBlackNodes(){

        ArrayList<T> values = new ArrayList<T>();

        for (Vertex<T> i : blackVertices)
            values.add(i.getLable());
      return values;
    }


    /*
     *@requires T must be immutable and have an overridden equals method
     *@modifies nothing.
     *@effects returns an ArrayList of type T with all the elements of white nodes from the graph. holds the reference to the objects themselves
     *@returns an array list with references to the white nodes in graph.
     */
    public ArrayList<T> listWhiteNodes(){
        ArrayList<T> whiteNodes = new ArrayList<T>();
        for(Vertex<T> i : whiteVertices){
            whiteNodes.add(i.getLable());
        }
        return whiteNodes;
    }




    /*
    *@requires T must be immutable and override equals method
    * @modifies nothing.
    * @effects returns an arraylist of the children of the parent label. if parentLabel is null or non existent
    *          throws an exception.
     */
    public ArrayList<T> listChildren(T parentLabel) throws NullPointerException {
        if(parentLabel == null) throw new NullPointerException();
        ArrayList<T> childrenLables = new ArrayList<T>();
        Vertex<T> parent = findLabel(parentLabel);
        if(parent == null) return childrenLables;
        ArrayList<Vertex<T>> children = parent.getChildren();
        for(Vertex<T> i : children){
            childrenLables.add(i.getLable());
        }
        return childrenLables;
    }

    /*
     *@requires T must be immutable and override equals method
     * @modifies nothing.
     * @effects returns an arraylist of the parents of the child label. if childLabel is null or non existent
     *          throws an exception.
     */
    public ArrayList<T> listParent(T childLabel) throws NullPointerException {
        if(childLabel == null) throw new NullPointerException();
        ArrayList<T> parentsLables = new ArrayList<T>();
        Vertex<T> child = findLabel(childLabel);
        if(child == null) return parentsLables;
        ArrayList<Vertex<T>> parents = child.getParents();
        for(Vertex<T> i : parents){
            parentsLables.add(i.getLable());
        }
        return parentsLables;
    }

    /*
    * @requires - T must be immutable and override equals method
    * @modifies - nothing.
    * @effects - returns the child label of type T that is connected with edge edgelabel to the parent parentlabel in this
     */
    public T getChildByEdgeLabel(T parentLabel, T edgeLabel) throws NullPointerException {
        if(parentLabel == null || edgeLabel == null) throw new NullPointerException();
        for(Edge<T> i : edges){
            if(i.getLable().equals(edgeLabel) && i.getParent().getLable().equals(parentLabel)){
                return i.getChild().getLable();
            }
        }
        return null;
    }


    /*
     * @requires - T must be immutable and override equals method
     * @modifies - nothing.
     * @effects - returns the parent label of type T that is connected with edge edgelabel to the child childlabel in this
     */
    public T getParentdByEdgeLabel(T childLable, T edgeLabel) throws NullPointerException {
        if(childLable == null || edgeLabel == null) throw new NullPointerException();
        for(Edge<T> i : edges){
            if(i.getLable().equals(edgeLabel) && i.getChild().getLable().equals(childLable)){
                return i.getParent().getLable();
            }
        }
        return null;
    }

    /*
     * @requires - T must be immutable and override equals method
     * @modifies - edges.
     * @effects - removes the edge from the graph
     */
    public void removeEdgeByChild(T childLable, T edgeLabel) throws NullPointerException{
        if(childLable == null || edgeLabel == null) throw new NullPointerException();
        for(Edge<T> i : edges){
            if(i.getLable().equals(edgeLabel) && i.getChild().getLable().equals(childLable)){
                i.getChild().removeParent(i.getParent());
                i.getParent().removeChild(i.getChild());
                edges.remove(i);
            }
        }
    }

    /*
     * @requires - T must be immutable and override equals method
     * @modifies - edges.
     * @effects - removes the edge from the graph
     */
    public void removeEdgeByParent(T parentLabel, T edgeLabel) throws NullPointerException{
        if(parentLabel == null || edgeLabel == null) throw new NullPointerException();
        for(Edge<T> i : edges) {
            if (i.getLable().equals(edgeLabel) && i.getParent().getLable().equals(parentLabel)) {
                i.getChild().removeParent(i.getParent());
                i.getParent().removeChild(i.getChild());
                edges.remove(i);
            }
        }
    }

    private void checkRep(){
        for (Edge<T> i : edges) {
            assert (findLabel(i.getParent().getLable()) != null);
            assert (findLabel(i.getChild().getLable()) != null);
        }


    }

    public void removeVertex(Vertex<T> v){
        if(v == null) {
            return;
        }
        Vertex<T> vertex = findLabel(v.getLable());
        if(vertex == null) {
            return;
        }
        for(Edge<T> i : edges){
            if(i.getChild().getLable().equals(vertex.getLable())){
                removeEdgeByChild(vertex.getLable() , i.getLable());
            }
            if(i.getParent().getLable().equals(vertex.getLable())){
                removeEdgeByParent(vertex.getLable() , i.getLable());
            }
        }
    }

}
