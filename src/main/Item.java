package src.main;
public class Item {
    private String itemID;
    private int itemPrice;
    private int itemQuantity;

    public Item(String id, int price, int quantity) {
        itemID = id;
        itemPrice = price; 
        itemQuantity = quantity;

    }

    public String getID() {
        return itemID;
    }

    public int getPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

}
