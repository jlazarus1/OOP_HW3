package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class Participant implements Simulatable<String>{
    String name;
    private ArrayList<Transaction> donationBuff;
    private final String wantedProduct;
    private final int wantedAmount;
    private int holdingAmount;

    public Participant(String name , String wantedProduct , int wantedAmount){
        holdingAmount = 0;
        this.name = name;
        this.wantedAmount = wantedAmount;
        this.wantedProduct = wantedProduct;
        donationBuff = new ArrayList<>();
    }


    @Override
    public void simulate(BipartiteGraph<String> graph) {
        if(graph == null) return;
        ArrayList<Object> children = graph.listChildrenObjects(name);
        ListIterator<Object> iter = children.listIterator();
        while(iter.hasNext() && donationBuff.size() != 0){
            Channel child = (Channel) iter.next();
            if(child.receiveTransaction(donationBuff.get(0))){
                donationBuff.remove(0);
                return;
            }
        }

    }

    public void receiveTransaction(Transaction product){
        if(product == null) return;
        if(product.getProduct().equals(wantedProduct)){
            if(holdingAmount < wantedAmount){
                holdingAmount += product.getAmount();
                if(holdingAmount > wantedAmount){
                    int newAmount = holdingAmount - wantedAmount;
                    Transaction newProduct = new Transaction(product.getProduct() , newAmount);
                    holdingAmount = wantedAmount;
                    donationBuff.add(newProduct);
                }
                return;
            }
        }
        donationBuff.add(product);
        return;
    }

    public int getStorageAmount(){
        return holdingAmount;
    }

    public int getRecycleAmount(){
        int sum = 0;
        for(Transaction tx : donationBuff){
            sum += tx.getAmount();
        }
        return sum;
    }
}
