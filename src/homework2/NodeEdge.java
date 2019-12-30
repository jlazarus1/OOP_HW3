package homework2;

public class NodeEdge<T> extends Node<T> {
    private T label;
    public NodeEdge(){}
    public NodeEdge(T label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object label){
        return this.label.equals(label);
    }

    public void simulate(BipartiteGraph graph) {
        System.out.println("I am simulating pipe");
    }

    public T getLabel(){
        return label;
    }
}
