package src.main;

public class CheckOut {
   
    private ItemsList itemsList;

    public CheckOut(){
        itemsList = new ItemsList();
    }
    public ItemsList scanItems(Item item){
        if(item==null){
            return null;
        }
        System.out.println("Scan item is " + item.getID());
        itemsList.add(item);
        return itemsList;
    }
    public ItemsList getItemsList(){
        return itemsList;
    }
}
