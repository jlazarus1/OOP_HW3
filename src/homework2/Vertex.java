package homework2;

import java.util.ArrayList;

public class Vertex<T> {

    private T lable;
    private boolean isVertexWhite;
    private ArrayList<Vertex<T>> parents;
    private ArrayList<Vertex<T>> children;


    public Vertex(T lable, boolean isWhite) {
        this.lable = lable;
        this.isVertexWhite = isWhite;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();;
    }
    public T getLable(){
        return lable;
    }
    public void addParent(Vertex<T> parent){
        this.parents.add(parent);
    }

    public void addChild(Vertex<T> child){
        this.parents.add(child);
    }

    public ArrayList<Vertex<T>> getChildren(){
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(children);
        return ret;
    }

    public ArrayList<Vertex<T>> getParents(){
        ArrayList<Vertex<T>> ret = new ArrayList<Vertex<T>>(parents);
        return ret;
    }
    public boolean getIsVertexWhite(){
        return isVertexWhite;
    }

    public void removeChild(Vertex<T> child){
        for(Vertex<T> i : children){
            if(i.equals(child.getLable())){
                children.remove(i);
            }
        }
    }
    public void removeParent(Vertex<T> parent){
        for(Vertex<T> i : parents){
            if(i.equals(parent.getLable())){
                children.remove(i);
            }
        }
    }
}
