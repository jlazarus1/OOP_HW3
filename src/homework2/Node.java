package homework2;

abstract public class Node<T> implements Simulatable<T>{
    private T label;

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
}
