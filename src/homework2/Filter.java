package homework2;

import java.util.ArrayList;

public class Filter<T, O> extends Node<T,O> {

    ArrayList<O> buffer;

public Filter(){
    this.buffer = new ArrayList<O>();
}
    public Filter(T label) {
        super(label);
        this.buffer = new ArrayList<O>();

    }


    public void addItem(O item) {
        if (item != null)
            buffer.add(item);
    }


    public boolean removeItem(O item) {
        if (item == null) return false;
        return buffer.remove(item);
    }

    public void simulate(BipartiteGraph graph) {
        System.out.println("I am simulating pipe");
    }
}
