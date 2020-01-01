package homework2;

import java.util.*;

//This class acts as a pipe to move Donations from one participant to another.
//It is used as part of a  simulation to simulate the transactions moving between different participants.

public class Channel implements Simulatable<String> {
    private String label;
    private final int capacity;
    private int holdingAmount;
    private ArrayList<Transaction> productArray;


    /*
    * @requires maxCapacity >= 0,
    * @modifies this
    * @returns this
     */
    public Channel(String label , int maxCapacity) throws NullPointerException{
        if (label == null) throw new NullPointerException();
        this.label = label;
        capacity = maxCapacity;
        productArray = new ArrayList<>();
    }

    /*
    * @requires nothing
    * @modifies this
    * @returns nothing
     */
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
    /*
    * @requires nothing
    * @modifies this
    * @returns true if the transaction went through, false otherwise
     */
    public boolean receiveTransaction(Object productObj) throws NullPointerException{

        if(productObj == null) throw new NullPointerException();
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

    /*
    * @requires nothing
    * @modifies nothing
    * @returns returns a string seperated by space of all the content in products array
    * @         if productArray is null, throws exception.
     */

    public String getContents() throws NullPointerException{
        if (productArray == null) throw new NullPointerException();
        boolean firstIter = true;
        String content = "";
                if (productArray.isEmpty())
                { content = "Channel " + label + " is empty";
                return content;
                }
                System.out.println("Content for " + label + " is:" );
        for(Transaction tx : productArray){
            if(!firstIter) content += " ";
            content += tx.toString();
            firstIter = false;
        }
        content += "\n";
        return content;
    }
}
