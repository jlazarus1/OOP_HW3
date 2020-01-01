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

    public void simulate() {

        ArrayList whites = graph.listWhiteObjects();
        ArrayList blacks = graph.listBlackObjects();
        if (blacks == null || whites == null) return;
        ListIterator blacksIter = blacks.listIterator();
        ListIterator whitesIter = whites.listIterator();
        while (blacksIter.hasNext()) {
            Simulatable<T> pipe = (Simulatable<T>) blacksIter.next();
            if (pipe == null) return;
            pipe.simulate(graph);
        }
        while (whitesIter.hasNext()) {
            Simulatable<T> filter = (Simulatable<T>) whitesIter.next();
            if (filter == null) return;
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


    public Object getObjByLabel(T label, boolean isPipe) {
        Object obj = null;
        if (isPipe) {
            obj = graph.getBlackObjByLabel(label);
        } else {
            obj = graph.getWhiteObjByLabel(label);
        }
        return obj;
    }

    public ArrayList<T> getEdges(){
        ArrayList<Edge<T>> edges = graph.listEdges();
        ArrayList<T> edgesLabels = new ArrayList<>();
        for(Edge<T> edge : edges){
            edgesLabels.add(edge.getLable());
        }
        return edgesLabels;
    }
}


