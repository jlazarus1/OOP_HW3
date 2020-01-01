package homework2;

import java.util.ArrayList;
import java.util.ListIterator;

/*
 * this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
 *
 */
public class Simulator<T, O> {

    private BipartiteGraph<T> graph;
    private int stepNum;

    public Simulator() {
        graph = new BipartiteGraph<T>();
        stepNum = 0;
    }


    /*
     * @Requires
     */
    public void simulate() {
        ArrayList blacks = graph.listBlackObjects();
        ArrayList whites = graph.listWhiteObjects();
        ListIterator blacksIter = blacks.listIterator();
        ListIterator whitesIter = whites.listIterator();
        while (blacksIter.hasNext()) {
            Simulatable<T> pipe = (Simulatable<T>) blacksIter.next();
            pipe.simulate(graph);
        }
        while (whitesIter.hasNext()) {
            Simulatable<T> filter = (Simulatable<T>) whitesIter.next();
            filter.simulate(graph);
        }
        stepNum++;
        //TODO iterate over white nodes
    }


    public void addPipe(T label, Object pipe) throws NullPointerException { // Black Vertex
        if (pipe == null || label == null) throw new NullPointerException();
        graph.addBlackNode(label, pipe);
    }


    public void addFilter(T label, Object filter) throws NullPointerException {
        if (filter == null || label == null) throw new NullPointerException();
        graph.addWhiteNode(label, filter);
    }


    public void addEdge(T parentName, T childName, T edgeLabel) {
        if (parentName == null || childName == null || edgeLabel == null) throw new NullPointerException();
        graph.addEdge(parentName, childName, edgeLabel);

    }


    public Object getObjByLabel(T label , boolean isPipe){
        Object obj = null;
        if(isPipe) {
            obj = graph.getBlackObjByLabel(label);
        }
        else {
            obj = graph.getWhiteObjByLabel(label);
        }
        return obj;
    }



    //TODO for sure not correct, need to change
    public void printEdges() {
        for (Edge<T> i : graph.listEdges()) {
            System.out.println(i.getLable());
        }
    }


}


