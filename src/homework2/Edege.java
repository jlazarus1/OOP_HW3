package homework2;

public class Edege<T> {
    private T lable;
    private Vertex<T> parent;
    private Vertex<T> child;

    public Edege(T lable , Vertex<T> parent , Vertex<T> child){
        this.lable = lable;
        this.parent = parent;
        this.child = child;
        this.parent.addChild(child);
        this.child.addParent(parent);
    }

    public Vertex<T> getParent(){
        return parent;
    }
    public Vertex<T> getChild(){
        return child;
    }
    public void setChild(Vertex<T> child){
        this.child = child;
    }
    public void setParent(){
        this.parent = parent;
    }
}
