package src.main;
public class Item {
    private String itemID;
    private int itemPrice;

    public Item(String id, int price, int quantity) {
        itemID = id;
        itemPrice = price; 

    }

    public String getID() {
        return itemID;
    }

    public int getPrice() {
        return itemPrice;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

}
