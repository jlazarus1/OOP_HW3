package homework2;

import java.util.ArrayList;
/*
* this class implements a simulator for a BipartiteGraph. It extends BipartiteGraph
*
 */
 public class Simulator <E, T extends Transaction> extends BipartiteGraph<Vertex<E>> {


    public Simulator(BipartiteGraph<Vertex<E>> graph){
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

    Pipe<E> temp = new Pipe<E>();
    temp.setCapacity(limit);
    temp.setLabel(channelName);

}

public void addParticipant(E participantName, E product, int amount ){

    Filter<E> temp = new Filter<E>();
    Item<E> item = new Item<E>(product,amount);
    temp.addItem(product);
    this.addWhiteNode(temp);
}





/*
* @Requires
* @
 */
public void sendTransaction(Pipe<E> edge, T tx) {

  if (tx.getAmount() > edge.getCapacity())
  {
      return;
  }

  edge.setCapacity(edge.getCapacity()-tx.getAmount());
}


}


