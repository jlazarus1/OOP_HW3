package homework2;

import java.util.ArrayList;
import java.util.ListIterator;

/*
* this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
*
 */
 public class Simulator <V , O>  {

     private BipartiteGraph<Node<V,O>> graph;

    public Simulator(){
     graph = new BipartiteGraph<Node<V,O>>();
    }


    /*
    * @Requires
     */
public void simulate(){
    ArrayList blacks = graph.listBlackNodes();
    ArrayList whites = graph.listBlackNodes();
    ListIterator blacksIter = blacks.listIterator();
    ListIterator whitesIter = whites.listIterator();
    while(blacksIter.hasNext()){
        Pipe<V,O> s = (Pipe<V,O>) blacksIter.next();
        s.simulate(graph);
    }
    while(whitesIter.hasNext()){
        Filter<V , O> s = (Filter<V , O>) whitesIter.next();
        s.simulate(graph);
    }

}

// TODO remove this method
public BipartiteGraph<Node<V,O>> getGraph(){return graph;}

public  void addPipe(Pipe<V,O> pipe) throws NullPointerException{ // Black Vertex
    if(pipe == null) throw new NullPointerException();
    graph.addBlackNode(pipe);
}



public void addFilter(Filter<V , O> filter) throws NullPointerException{
    if(filter == null) throw new NullPointerException();
    graph.addWhiteNode(filter);
}

public Node<V,O> findNode(V label){
    for (Node<V,O> i : graph.listBlackNodes())
    {
        if (i.getLabel().equals(label)) return i;
    }
    for (Node<V,O> i : graph.listWhiteNodes())
    {
        if (i.getLabel().equals(label)) return i;
    }
    return null;
}

public void sendTransaction(V label,O Tx)
{
    findNode(label);


}


public void addEdge(V parentName, V childName, V edgeLabel){
    Node<V,O> edge = new NodeEdge<>(edgeLabel);

    graph.addEdge(findNode(parentName),findNode(childName),edge);

}

//TODO for sure not correct, need to change
public void printEdges(){
    for (Edge<Node<V,O>> i: graph.listEdges())
    {
        System.out.println(i.getLable().getLabel());

    }


}





}


