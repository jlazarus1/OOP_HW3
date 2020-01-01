package homework2;

import java.util.ArrayList;

public class Vertex<T> {

    private T label;
    private Object actualNode = null;
    private boolean isVertexWhite;
    private ArrayList<Vertex<T>> parents;
    private ArrayList<Vertex<T>> children;

    public Vertex(T label, boolean isWhite) {
        this.label = label;
        this.isVertexWhite = isWhite;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();;
    }

    public Vertex(T label, boolean isWhite , Object nodeType){
        this.label = label;
        this.isVertexWhite = isWhite;
        this.actualNode = nodeType;
        this.parents = new ArrayList<Vertex<T>>();
        this.children = new ArrayList<Vertex<T>>();;
    }
    public Object getActualNode(){
        return actualNode;
    }
    public T getLabel(){
        return label;
    }
    public void addParent(Vertex<T> parent){
        this.parents.add(parent);
    }

    public void addChild(Vertex<T> child){
        this.children.add(child);
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
            if(i.getLabel().equals(child.getLabel())){
                children.remove(i);
            }
        }
    }
    public void removeParent(Vertex<T> parent){
        for(Vertex<T> i : parents){
            if(i.getLabel().equals(parent.getLabel())){
                children.remove(i);
            }
        }
    }

}
