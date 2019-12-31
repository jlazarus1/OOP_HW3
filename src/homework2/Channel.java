package homework2;

import java.util.*;

public class Channel implements Simulatable<String> {
    private String label;
    private final int capacity;
    private int holdingAmount;
    private ArrayList<Transaction> productArray;

    public Channel(String label , int maxCapacity){
        this.label = label;
        capacity = maxCapacity;
        productArray = new ArrayList<>();
    }

    @Override
    public void simulate(BipartiteGraph<String> graph) {
        if(graph == null) return;
        ArrayList<Object> children = graph.listChildrenObjects(label);
        if(children.size() != 0 && productArray.size() != 0){
            Participant child = (Participant) children.get(0);
            child.receiveTransaction(productArray.get(0));
            holdingAmount -= productArray.get(0).getAmount();
            productArray.remove(0);
        }
    }

    public boolean receiveTransaction(Object productObj){
        Transaction product = (Transaction) productObj;
        if(product == null) return false;
        int maxAmount = capacity - holdingAmount;
        if(maxAmount == 0) return false;
        if(maxAmount < product.getAmount()){
            holdingAmount = capacity;
            productArray.add(new Transaction(product.getProduct() , maxAmount));
            return true;
        }
        else{
            holdingAmount += product.getAmount();
            productArray.add(product);
        }
        return true;
    }

    public String getContents(){
        boolean firstIter = true;
        String content = "";
        for(Transaction tx : productArray){
            if(!firstIter) content += " ";
            content += tx.toString();
            firstIter = false;
        }
        return content;
    }
}
