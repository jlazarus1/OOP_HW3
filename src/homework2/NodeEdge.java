package homework2;

public class NodeEdge<T,O> extends Node<T,O> {
    private T label;


    public NodeEdge(T label) {
        super(label);
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
