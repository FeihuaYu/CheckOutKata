package src.test;

import org.junit.Test;

import src.main.CheckOut;
import src.main.Item;
import src.main.ItemsList;
import src.main.PromotionItems;
import src.main.PromotionMultiPrice;
import src.main.PromotionOneFree;
import src.main.TotalPrice;

import static org.junit.Assert.*;


public class CheckOutTest{

    static Item itemA;
    static Item itemB;
    static Item itemC;
    static Item itemD;
    static Item itemE;
    static PromotionMultiPrice promotionMultiPrice;
    static PromotionOneFree promotionOneFree;
    static PromotionItems promotionItems;

    
    public static void init(){
        itemA = new Item("A", 50, 1);
        itemB = new Item("B", 75, 1);
        itemC = new Item("C", 25, 1);
        itemD = new Item("D", 150, 1);
        itemE = new Item("E", 200, 1);

        promotionMultiPrice = new PromotionMultiPrice();
        promotionOneFree = new PromotionOneFree();
        promotionItems = new PromotionItems(promotionMultiPrice, promotionOneFree);

    }

    public static Integer scan(String items){
        CheckOut checkOut = new CheckOut();
        for(int i = 0; i < items.length(); i++) {
            switch (items.substring(i, i+1)){
                case "A":
                checkOut.scanItems(itemA);
                break;
                case "B":
                checkOut.scanItems(itemB);
                break;
                case "C":
                checkOut.scanItems(itemC);
                break;
                case "D":
                checkOut.scanItems(itemD);
                break;
                case "E":
                checkOut.scanItems(itemE);
            }

        }

        return price(checkOut);
    }

    public static Integer price(CheckOut checkOut){
        ItemsList itemsList = checkOut.getItemsList();
        TotalPrice totalPrice = new TotalPrice(itemsList, promotionItems);
        int result = totalPrice.calculatePrice();
        System.out.println(result);
        return result;
    }


    @Test
    public static void testPrice() throws Exception{
        assertEquals(Integer.valueOf(50), scan("A"));
        assertEquals(Integer.valueOf(100), scan("AA"));
        assertEquals(Integer.valueOf(150), scan("AAA"));
        assertEquals(Integer.valueOf(150), scan("ABC"));
        assertEquals(Integer.valueOf(225), scan("BD"));
        assertEquals(Integer.valueOf(75), scan("B"));
        assertEquals(Integer.valueOf(125), scan("BB"));
        assertEquals(Integer.valueOf(200), scan("BBB"));
        assertEquals(Integer.valueOf(250), scan("BBBB"));
        assertEquals(Integer.valueOf(175), scan("BAB"));
        assertEquals(Integer.valueOf(25), scan("C"));
        assertEquals(Integer.valueOf(50), scan("CC"));
        assertEquals(Integer.valueOf(50), scan("CCC"));
        assertEquals(Integer.valueOf(75), scan("CCCC"));
        assertEquals(Integer.valueOf(100), scan("CCCCC"));
        assertEquals(Integer.valueOf(100), scan("CCCCCC"));
        assertEquals(Integer.valueOf(150), scan("D"));
        assertEquals(Integer.valueOf(300), scan("DD"));
        // assertEquals(Integer.valueOf(300), scan("DE"));
        // assertEquals(Integer.valueOf(450), scan("DDE"));
        // assertEquals(Integer.valueOf(200), scan("E"));
        // assertEquals(Integer.valueOf(400), scan("EE"));
        // assertEquals(Integer.valueOf(300), scan("ED"));
        // assertEquals(Integer.valueOf(500), scan("EDE"));
        // assertEquals(Integer.valueOf(600), scan("EDDE"));
        // assertEquals(Integer.valueOf(750), scan("EEDDD"));
    }

    public static void main(String[] args) throws Exception{
        init();
        testPrice();

    }

    
}
