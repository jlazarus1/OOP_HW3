package homework2;

import java.util.ArrayList;

public class Pipe<T> extends Node<T> {

    int capacity;

    public Pipe(T label , int capacity){
        super(label);
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void simulate(BipartiteGraph graph) {
        System.out.println("I am simulating pipe");
    }

}
