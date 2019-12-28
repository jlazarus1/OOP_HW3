package homework2;

import java.util.ArrayList;
/*
* this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
*
 */
 public class Simulator<E extends Simulatable<E>,T extends Simulatable<E>> extends BipartiteGraph {

    BipartiteGraph<E> graph_to_sim;


    public Simulator(BipartiteGraph graph){
        graph_to_sim = new BipartiteGraph();
    }


    /*
    * @Requires
     */
public void simulate(){

        for ( E i : graph_to_sim.listBlackNodes())
        {
            i.simulate(graph_to_sim);
        }

        for (E i : graph_to_sim.listWhiteNodes())
        {
         i.simulate(graph_to_sim);
        }


}

public void sendTransaction(E edge, T tx){

    Vertex<E> label = graph_to_sim.findLabel(edge);
    E l = label.getLable();





}

}
