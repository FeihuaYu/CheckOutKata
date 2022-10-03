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

        itemsList.add(item);
        return itemsList;
    }

    public ItemsList getItemsList(){
        return itemsList;
    }
}
