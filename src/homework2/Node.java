package homework2;

import java.util.ArrayList;

abstract public class Node<T,O> implements Simulatable<T>{
    private T label;
    private ArrayList<O> items;
    private int amount;

    public Node(){}
    public Node(T label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object label){
        return this.label.equals(label);
    }

    abstract public void simulate(BipartiteGraph<T> graph);
    public T getLabel(){
        return label;
    }

    public void setItem(O item) {
        items.add(item);
    }

    public void getItem(O item){
        items.remove(item);

    }

    public ArrayList<O> getItems() {
        return items;
    }

    public void setLabel(T label) {
        this.label = label;
    }
}
