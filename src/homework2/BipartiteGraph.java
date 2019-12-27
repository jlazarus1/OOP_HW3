package homework2;




/*
This class Implements a generic Bipartite Graph. The nodes and Vertexes may be of any class.

 */

import java.util.ArrayList;


public class BipartiteGraph {


    /*
     * @requires type must be a type that is immutable and has an overridden equals method
     * @ modifies this.
     * @effects creates a new graph with graphLabel as its Label. if graphLabel is null, throws exception
     */

    public <T> BipartiteGraph(T graphLabel) throws NullPointerException{}


    /*
    *@requires T must have an overridden equals method
    * @modifies this.
    * @effects creates a graph with a black node with nodeLabel as label.
    * if nodeLabel == null, will throw exception.
    *
     */
    public <T> void addBlackNode(T nodeLabel) throws NullPointerException
    {}


    /*
     *@requires  type T must have an overridden equals method
     * @modifies this.
     * @effects creates a graph with a black node with nodeLabel as label.
     * if nodeLabel == null, will throw exception.
     *
     */
    public <T> void addWhiteNode(T nodeLabel) throws NullPointerException
    {}


    /*
    *@requires T must be immutable and have an overridden equals method
    *@ modifies this.
    *@effects adds an edge to a specific graph at a specific point. if one of the
    *         labels is null or non existent, throws an exception
    *
    *
     */

    public <T> void addEdge(T parentLabel, T childLabel, T edgeLabel) throws NullPointerException{}

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
    public <T> ArrayList<T> listChildren(T parentLabel) throws NullPointerException {}

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
