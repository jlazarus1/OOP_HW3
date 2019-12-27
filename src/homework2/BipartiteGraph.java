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
    public void addWhiteNode(T nodeLabel) throws NullPointerException
    {
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert = new Vertex<T>(nodeLabel, true);
        whiteVertices.add(vert);


    }



    /*
    * @requires nothing
    * @ returns reference to the vertex of contained label. if no vertex is found, returns null
     */

    private Vertex<T> findLabel(T label) throws  NullPointerException{

        if (label == null) throw new NullPointerException();
        for (Vertex<T> i : blackVertices)
            if(i.equals(label)) return i;

        for (Vertex<T> i : whiteVertices)
            if(i.equals(label))return i;

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

        if (parentLabel ==null || childLabel == null || edgeLabel == null) throw new NullPointerException();

        // check if the parent and child labels exist in the graph
        if (findLabel(parentLabel)==null || findLabel(childLabel) == null) return  false;

        // check if both parent and child are white, if so you may not connect them
        if (findLabel(parentLabel).getIsVertexWhite() == findLabel(childLabel).getIsVertexWhite()) return false;

        findLabel(parentLabel).addChild(findLabel(childLabel));
        findLabel(childLabel).addParent(findLabel(parentLabel));
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
        Vertex<T> parent = findLabel(parentLabel);
        if(parent == null) return null;
        ArrayList<Vertex<T>> children = parent.getChildren();
        ArrayList<T> childrenLables = new ArrayList<T>();
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
        Vertex<T> child = findLabel(childLabel);
        if(child == null) return null;
        ArrayList<Vertex<T>> parents = child.getParents();
        ArrayList<T> parentsLables = new ArrayList<T>();
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
        for(Edege<T> i : edges){
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
        for(Edege<T> i : edges){
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
        for(Edege<T> i : edges){
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
        for(Edege<T> i : edges) {
            if (i.getLable().equals(edgeLabel) && i.getParent().getLable().equals(parentLabel)) {
                i.getChild().removeParent(i.getParent());
                i.getParent().removeChild(i.getChild());
                edges.remove(i);
            }
        }
    }
}
