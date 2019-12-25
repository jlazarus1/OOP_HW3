package homework2;

import java.util.ArrayList;

public class Vertex<T> {

    private T lable;
    private String color;
    private ArrayList<T> parents;
    private ArrayList<T> children;


    public Vertex(T lable, String color) {
        this.lable = lable;
        this.color = color;
        this.parents = new ArrayList<T>();
        this.children = new ArrayList<T>();;
    }

    public void addParent(T parent){
        this.parents.add(parent);
    }

    public void addChild(T parent){
        this.parents.add(parent);
    }

    public int getNumOfChildren(){
        return this.children.size();
    }

    public int getNumOfParents(){
        return this.parents.size();
    }
    public T getChild(T child){
        for(T el : children){
            if(el.equals(child)){
                return el;
            }
        }
        return null;
    }
}
