package homework2;





/*
This class Implements a generic Bipartite Graph. The nodes and Vertexes may be of any class.



 */

import java.util.ArrayList;


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
    * @effects creates a black node with nodeLabel as label.
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
     * @requires T must have an overridden equals method
     * @modifies this.
     * @effects creates a black node with label nodeLabel and with object vertexType in Object field
     *
     */
    public void addBlackNode(T nodeLabel , Object vertexType) throws NullPointerException
    {
        checkRep();
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert= new Vertex<T>(nodeLabel, false , vertexType);
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
     * @requires T must be immutable
     * @modifies nothing
     * @returns returns the object field of the black node named label
     *          throws exception if label is null.
     */
    public void addWhiteNode(T nodeLabel , Object vertexType) throws NullPointerException
    {
        checkRep();
        if (vertexType == null) throw new NullPointerException();
        if (nodeLabel == null) throw new NullPointerException();
        Vertex<T> vert = new Vertex<T>(nodeLabel, true , vertexType);
        whiteVertices.add(vert);
        checkRep();

    }


    /*
    * @requires nothing
    * @ returns reference to the vertex of contained label. if no vertex is found, returns null
     */

    public Vertex<T> findLabel(T label) throws  NullPointerException{

        if (label == null) throw new NullPointerException();
        for (Vertex<T> i : blackVertices)
            if(i.getLabel().equals(label)) return i;

        for (Vertex<T> i : whiteVertices)
            if(i.getLabel().equals(label))return i;

        return null;

    }

    /*
    *@requires T must be immutable and have an overridden equals method
    *@ modifies this.
    *@effects adds an edge to a specific graph at a specific point. if one of the
    *         labels is null or non existent, throws an exception
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
            values.add(i.getLabel());
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
            whiteNodes.add(i.getLabel());
        }
        return whiteNodes;
    }

    /*
    * @returns a new array list with the edges of this graph.
     */

    public ArrayList<Edge<T>> listEdges(){
        ArrayList<Edge<T>> list = new ArrayList<Edge<T>>();
        list = edges;
        return list;
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
            childrenLables.add(i.getLabel());
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
            parentsLables.add(i.getLabel());
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
            if(i.getLable().equals(edgeLabel) && i.getParent().getLabel().equals(parentLabel)){
                return i.getChild().getLabel();
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
            if(i.getLable().equals(edgeLabel) && i.getChild().getLabel().equals(childLable)){
                return i.getParent().getLabel();
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
            if(i.getLable().equals(edgeLabel) && i.getChild().getLabel().equals(childLable)){
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
            if (i.getLable().equals(edgeLabel) && i.getParent().getLabel().equals(parentLabel)) {
                i.getChild().removeParent(i.getParent());
                i.getParent().removeChild(i.getChild());
                edges.remove(i);
            }
        }
    }

    //Check rep function for the Bipartite Graph class

    private void checkRep(){
        for (Edge<T> i : edges) {
            assert (findLabel(i.getParent().getLabel()) != null);
            assert (findLabel(i.getChild().getLabel()) != null);
        }


    }

    /*
    * @Requires nothing
    * @modifies this
    * @returns nothing.
     */
    public void removeVertex(Vertex<T> v) {
        if(v == null) {
            return;
        }
        Vertex<T> vertex = findLabel(v.getLabel());
        if(vertex == null) {
            return;
        }
        for(Edge<T> i : edges){
            if(i.getChild().getLabel().equals(vertex.getLabel())){
                removeEdgeByChild(vertex.getLabel() , i.getLable());
            }
            if(i.getParent().getLabel().equals(vertex.getLabel())){
                removeEdgeByParent(vertex.getLabel() , i.getLable());
            }
        }
    }

    /*
    * @requires T must be immutable
    * @modifies nothing
    * @returns a list of object's that are in parentName's children Object field.
    *           throws an exception if parentName is null
     */
    public ArrayList<Object> listChildrenObjects(T parentName) throws NullPointerException{
        if(parentName == null) throw new NullPointerException();
        ArrayList<Object> childrenObjList = new ArrayList<>();
        ArrayList<Vertex<T>> children = findLabel(parentName).getChildren();
        for(Vertex<T> i : children){
            childrenObjList.add(i.getActualNode());
        }
        return  childrenObjList;
    }

    /*
     * @requires nothing
     * @modifies nothing
     * @returns a list of the graphs black objects, the ones that are in the object field
     */

    public ArrayList<Object> listBlackObjects(){
        ArrayList<Object> blackObjList = new ArrayList<>();
        for(Vertex<T> i : blackVertices){
            blackObjList.add(i.getActualNode());
        }
        return  blackObjList;
    }

    /*
     * @requires nothing
     * @modifies nothing
     * @returns a list of the graphs white objects, the ones that are in the object field
     */

    public ArrayList<Object> listWhiteObjects(){
        ArrayList<Object> whiteObjList = new ArrayList<>();
        for(Vertex<T> i : whiteVertices){
            whiteObjList.add(i.getActualNode());
        }
        return  whiteObjList;
    }


    /*
     * @requires T must be immutable
     * @modifies nothing
     * @returns returns the object field of the black node named label
     *          throws exception if label is null.
     */
    public Object getBlackObjByLabel(T label) throws NullPointerException{
        if(label == null) throw new NullPointerException();
        for(Vertex<T> i : blackVertices){
            if(i.getLabel().equals(label)){
                return i.getActualNode();
            }
        }
        return null;
    }

    /*
     * @requires T must be immutable
     * @modifies nothing
     * @returns returns the object field of the white node named label
     *          throws exception if label is null.
     */
    public Object getWhiteObjByLabel(T label) throws NullPointerException{
        if(label == null) throw new NullPointerException();
        for(Vertex<T> i : whiteVertices){
            if(i.getLabel().equals(label)){
                return i.getActualNode();
            }
        }
        return null;
    }

}
