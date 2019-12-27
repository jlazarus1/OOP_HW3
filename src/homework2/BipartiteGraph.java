package homework2;





/*
This class Implements a generic Bipartite Graph. The nodes and Vertexes may be of any class.

 */

import java.util.ArrayList;


public class BipartiteGraph<T> {
    private ArrayList<Vertex<T>> blackVertices;
    private ArrayList<Vertex<T>> whiteVertices;
    private ArrayList<Edege<T>> edges;


    /*
     * @requires type must be a type that is immutable and has an overridden equals method
     * @ modifies this.
     * @effects creates a new graph with graphLabel as its Label. if graphLabel is null, throws exception
     */

    public BipartiteGraph() {
        blackVertices = new ArrayList<Vertex<T>>();
        whiteVertices = new ArrayList<Vertex<T>>();
        edges = new ArrayList<Edege<T>>();
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
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert= new Vertex<T>(nodeLabel, false);
        blackVertices.add(vert);

    }


    /*
     *@requires  type T must have an overridden equals method
     * @modifies this.
     * @effects creates a graph with a black node with nodeLabel as label.
     * if nodeLabel == null, will throw exception.
     *
     */
    public <T> void addWhiteNode(T nodeLabel) throws NullPointerException
    {
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert = new Vertex<T>(nodeLabel, true);
        whiteVertices.add(vert);


    }


    /*
    *@requires T must be immutable and have an overridden equals method
    *@ modifies this.
    *@effects adds an edge to a specific graph at a specific point. if one of the
    *         labels is null or non existent, throws an exception
    *
    *
     */

    private Vertex<T> findLabel(T label){

        for (Vertex<T> i : blackVertices)
            if(i.equals(label)) return i;

        for (Vertex<T> i : whiteVertices)
            if(i.equals(label))return i;


        return null;

    }

    public <T> boolean addEdge(T parentLabel, T childLabel, T edgeLabel) throws NullPointerException{

        if (parentLabel ==null || childLabel == null || edgeLabel == null) throw new NullPointerException();





    }

    /*
    *@requires T must be immutable and have an overridden equals method
    *@modifies nothing.
    *@effects returns an ArrayList of type T with all the elements of black nodes from the graph. holds the reference to the objects themselves
    *@returns an array list with references to the black nodes in graph.
     */
    public <T> ArrayList<T> listBlackNodes(){return}

    /*
     *@requires T must be immutable and have an overridden equals method
     *@modifies nothing.
     *@effects returns an ArrayList of type T with all the elements of white nodes from the graph. holds the reference to the objects themselves
     *@returns an array list with references to the white nodes in graph.
     */
    public <T> ArrayList<T> listWhiteNodes(){return}



    /*
    *@requires T must be immutable and override equals method
    * @modifies nothing.
    * @effects returns an arraylist of the children of the parent label. if parentLabel is null or non existent
    *          throws an exception.
     */
    public ArrayList<T> listChildren(T parentLabel) throws NullPointerException {}

    /*
     *@requires T must be immutable and override equals method
     * @modifies nothing.
     * @effects returns an arraylist of the parents of the child label. if childLabel is null or non existent
     *          throws an exception.
     */
    public <T> ArrayList<T> listParent(T childLabel) throws NullPointerException {}

    /*
    * @requires - T must be immutable and override equals method
    * @modifies - nothing.
    * @effects - returns the child label of type T that is connected with edge edgelabel to the parent parentlabel in this
     */
    public <T> T getChildByEdgeLabel(T parentLabel, T edgeLabel) throws NullPointerException {}


    /*
     * @requires - T must be immutable and override equals method
     * @modifies - nothing.
     * @effects - returns the parent label of type T that is connected with edge edgelabel to the child childlabel in this
     */
    public <T> T getParentdByEdgeLabel(T parentLabel, T edgeLabel) throws NullPointerException {}

}
