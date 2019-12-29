package homework2;

import java.util.ArrayList;
/*
* this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
*
 */
 public class Simulator <E, T extends Transaction> extends BipartiteGraph<Vertex<E>> {

    BipartiteGraph<Vertex<E>> graph_to_sim;


    public Simulator(BipartiteGraph graph){
       super();
    }


    /*
    * @Requires
     */
public void simulate(){

        for ( Vertex<E> i : this.listBlackNodes())
        {
            i.simulate(this);
        }

        for (Vertex<E> i : this.listWhiteNodes())
        {
         i.simulate(this);
        }

}
//TODO use a constructor with channelName
public  void addChannel(E channelName, int limit){

    Pipe temp = new Pipe();
    temp.setCapacity(limit);
    temp.setLabel(channelName);
    this.addBlackNode(temp);

}

public void addParticipant(E participantName, E product, int amount ){

    Filter temp = new Filter();
    Item item = new Item(product,amount);
    temp.addItem(item);
    this.addWhiteNode(temp);
}









/*
* @Requires
* @
 */
public void sendTransaction(Pipe edge, T tx) {

  if (tx.getAmount() > edge.getCapacity())
  {
      return;
  }

  edge.setCapacity(edge.getCapacity()-tx.getAmount());
}

}
