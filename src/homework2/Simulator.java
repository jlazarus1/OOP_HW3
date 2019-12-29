package homework2;

import java.util.ArrayList;
import java.util.ListIterator;

/*
* this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
*
 */
 public class Simulator <V , O>  {

     private BipartiteGraph<Node<V>> graph;

    public Simulator(){
     graph = new BipartiteGraph<Node<V>>();
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
        Pipe<V> s = (Pipe<V>) blacksIter.next();
        s.simulate(graph);
    }
    while(whitesIter.hasNext()){
        Filter<V , O> s = (Filter<V , O>) whitesIter.next();
        s.simulate(graph);
    }

}

public  void addPipe(Pipe<V> pipe) throws NullPointerException{ // Black Vertex
    if(pipe == null) throw new NullPointerException();
    graph.addBlackNode(pipe);
}

public void addFilter(Filter<V , O> filter) throws NullPointerException{
    if(filter == null) throw new NullPointerException();
    graph.addWhiteNode(filter);
}

public void addEdge(V parentName, V childName, V edgeLabel){
//    Node<V>  parent = new Node<V>(parentName);
//    graph.addEdge(Node<V>parentName , childName , edgeLabel);

}



}


