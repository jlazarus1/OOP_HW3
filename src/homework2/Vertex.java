package homework2;

import java.util.ArrayList;

public class Vertex<T> {

    private T lable;
    private boolean isVertexWhite;
    private ArrayList<T> parents;
    private ArrayList<T> children;


    public Vertex(T lable, boolean isWhite) {
        this.lable = lable;
        this.isVertexWhite = isWhite;
        this.parents = new ArrayList<T>();
        this.children = new ArrayList<T>();;
    }
    public T getLable(){
        return lable;
    }
    public boolean addParent(Vertex<T> parent){
        if(this.isVertexWhite == parent.getIsVertexWhite()) return false;
        this.parents.add(parent.getLable());
        return true;
    }

    public boolean addChild(Vertex<T> child){
        if(this.isVertexWhite == child.getIsVertexWhite()) return false;
        this.parents.add(child.getLable());
        return true;
    }

    public ArrayList<T> getChildren(){
        ArrayList<T> ret = new ArrayList<>(children);
        return ret;
    }

    public ArrayList<T> getParents(){
        ArrayList<T> ret = new ArrayList<>(parents);
        return ret;
    }
    public boolean getIsVertexWhite(){
        return isVertexWhite;
    }
}
