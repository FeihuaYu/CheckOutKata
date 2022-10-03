package src.main;

public class CheckOut {
    private ShoppingCart itemsList;

    public CheckOut(){
        itemsList = new ShoppingCart();
        
    }


    public ShoppingCart scanItems(Item item){
        if(item==null){
            return null;
        }

        itemsList.add(item);
        return itemsList;
    }

    public ShoppingCart getItemsList(){
        return itemsList;
    }
}
