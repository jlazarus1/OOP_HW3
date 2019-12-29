package homework2;

import java.util.ArrayList;

public class Filter<E>  extends Vertex<E> {

    ArrayList<E> buffer;


 public Filter(){
     this.buffer= new ArrayList<E>();

 }


 public void addItem(E item){

        buffer.add(item);
    }


 public boolean removeItem(E item){
     if (buffer.remove(item)==true)
         return true;

     else return false;
 }

    @Override
    public void simulate(BipartiteGraph graph) {
        //TODO
    }
}
