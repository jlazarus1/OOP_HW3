package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
//This class implements a Participant in a simulation of recycling items.
//the participant may receive transactions and send them to the next participant via a channel if he does not need them.
public class Participant implements Simulatable<String>{
    String name;
    private ArrayList<Transaction> donationBuff;
    private final String wantedProduct;
    private final int wantedAmount;
    private int holdingAmount;


    /*
    * @requires nothing
    * @modifies this
    * @returns this
     */
    public Participant(String name , String wantedProduct , int wantedAmount) throws NullPointerException{
        if (name ==null || wantedProduct ==null) throw new NullPointerException();
        holdingAmount = 0;
        this.name = name;
        this.wantedAmount = wantedAmount;
        this.wantedProduct = wantedProduct;
        donationBuff = new ArrayList<>();
    }

    /*
    * @requires nothing
    * @modifies this
    * @returns if the list of children is null or donationBuff is null, will throw NullPointerException
     */
    @Override
    public void simulate(BipartiteGraph<String> graph) throws NullPointerException{
        if(graph == null) return;
        ArrayList<Object> children = graph.listChildrenObjects(name);
        if (children == null || donationBuff == null) throw new NullPointerException();
        ListIterator<Object> iter = children.listIterator();
        while(iter.hasNext() && donationBuff.size() != 0){
            Channel child = (Channel) iter.next();
            if(child.receiveTransaction(donationBuff.get(0))){
                donationBuff.remove(0);
                return;
            }
        }

    }

    /*
    * takes a product and checks if it is needed by the participant, if so, adds it to the list, if not adds it to donation buffer.
    * @requires nothing.
    * @modifies this
    * @returns throws exception if donationBuff is null.
     */
    public void receiveTransaction(Transaction product) throws NullPointerException{
        if (donationBuff == null) throw new NullPointerException();
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
    //@effects returns holdingAmount
    public int getStorageAmount(){
        return holdingAmount;
    }

    /*
    * @effects returns the RecycleAmount for this participant
    *           throws exception if donationBuff is empty.
     */
    public int getRecycleAmount() throws NullPointerException{
        if (donationBuff ==null ) throw new NullPointerException();
        int sum = 0;
        for(Transaction tx : donationBuff){
            sum += tx.getAmount();
        }
        return sum;
    }
}
