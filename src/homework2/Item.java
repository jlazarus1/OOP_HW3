package homework2;

public class Item<E> {

    int amount;
    E item;

    public Item(E it, int amm){
        this.amount=amm;
        this.item=item;
    }

    public E getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
