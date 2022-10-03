package src.main;

public class CheckOut {
    private ShoppingCart cart;

    public CheckOut(){
        cart = new ShoppingCart();
        
    }


    public ShoppingCart scanItems(Item item){
        if(item==null){
            return null;
        }

        cart.add(item);
        return cart;
    }

    public ShoppingCart getItemsList(){
        return cart;
    }
}
