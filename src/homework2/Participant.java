package homework2;

import java.util.ArrayList;

public class Participant<T,O> extends Filter<T,O> {
    private ArrayList<O> RecycleList__ ;

    public Participant(){
        super();
        ArrayList<O> temp = new ArrayList<O>();
        this.RecycleList__ = temp;

    }



    public void addRecycle(O item){
        RecycleList__.add(item);
    }

    public ArrayList<O> getRecycleList__(){
        return RecycleList__;
    }
}
