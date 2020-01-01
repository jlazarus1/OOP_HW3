package homework2;

import java.util.ArrayList;
import java.util.ListIterator;

/*
 * this class implements a simulator for a BipartiteGraph. It is used to simulate using Pipes and Filters but
 * may be used with any 2 objects acting as white and black nodes.
 */
public class Simulator<T, O> {

    private BipartiteGraph<T> graph;
    private int stepNum;


    /*
    * @requires nothing
    * @modifies this
    * @returns this
     */
    public Simulator() {
        graph = new BipartiteGraph<T>();
        stepNum = 0;
    }


    /*
     * @Requires nothing
     * @modifies this
     * @returns throws exceptions if the lists of white or black nodes are null, and if the object in the nodes is null
     *          will throws exception
     */
    public void simulate() throws NullPointerException {
        ArrayList blacks = graph.listWhiteObjects();
        ArrayList whites = graph.listWhiteObjects();
        if (blacks == null || whites == null ) throw new NullPointerException();
        ListIterator blacksIter = blacks.listIterator();
        ListIterator whitesIter = whites.listIterator();
        while (blacksIter.hasNext()) {
            Simulatable<T> pipe = (Simulatable<T>) blacksIter.next();
            if (pipe == null) throw new NullPointerException();
            pipe.simulate(graph);
        }
        while (whitesIter.hasNext()) {
            Simulatable<T> filter = (Simulatable<T>) whitesIter.next();
            if (filter == null) throw new NullPointerException();
            filter.simulate(graph);
        }
        stepNum++;
        //TODO iterate over white nodes
    }

        /*
        * @requires nothing
        * @modifies this
        * @returns throws exception if label or object pipe are null.
         */
    public void addPipe(T label, Object pipe) throws NullPointerException { //Black Vertex
        if (pipe == null || label == null) throw new NullPointerException();
        graph.addBlackNode(label, pipe);
    }

    /*
     * @requires nothing
     * @modifies this
     * @returns throws exception if label or object filter are null.
     */
    public void addFilter(T label, Object filter) throws NullPointerException {
        if (filter == null || label == null) throw new NullPointerException();
        graph.addWhiteNode(label, filter);
    }

    /*
     * @requires nothing
     * @modifies this
     * @returns throws exception if parentName, childName or edgeLabel are null
     */

    public void addEdge(T parentName, T childName, T edgeLabel) throws NullPointerException {
        if (parentName == null || childName == null || edgeLabel == null) throw new NullPointerException();
        graph.addEdge(parentName, childName, edgeLabel);

    }

    /*
     * @requires nothing
     * @modifies this
     * @returns throws exception if channelName or the tx are null
     */
    public void sendObject(T channelName, O tx) throws NullPointerException{
        if (channelName == null || tx == null) throw new NullPointerException();
        Channel ch = (Channel) graph.getBlackObjByLabel(channelName);
        if(ch == null) return;
        ch.receiveTransaction(tx);
    }


    /*
     * @requires nothing
     * @modifies this
     * @returns throws exception if channelName is null.
     *          returns the list of content in the channelName item.
     */
    public String listContents(T channelName) throws NullPointerException{
        if (channelName == null) throw new NullPointerException();
        Channel ch = (Channel) graph.getBlackObjByLabel(channelName);
        if(ch == null) return "";
        String contents = ch.getContents();
        return contents;
    }


    /*
    * @returns nothing. prints to the screen the edges of the graph.
     */
    //TODO for sure not correct, need to change
    public void printEdges() {
        for (Edge<T> i : graph.listEdges()) {
            System.out.println(i.getLable());
        }
    }


}


