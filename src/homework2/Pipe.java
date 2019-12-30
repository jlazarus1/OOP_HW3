package homework2;

import java.util.ArrayList;

public class Pipe<T,O> extends Node<T,O> {

    int capacity;
    int available;
    //TODO had to add a default constructor so that i could extend Channel, what should we implement here?
    public Pipe(){}
    public Pipe(T label , int capacity){
        super(label);
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setAvailable(int available) {
        this.available = available;
    }


    public int getAvailable(){return available;}

    public void simulate(BipartiteGraph graph) {
        System.out.println("I am simulating pipe");
    }

}
