package src.test;

import org.junit.Test;

import src.main.CheckOut;
import src.main.Item;
import src.main.ShoppingCart;
import src.main.PromotionItems;
import src.main.PromotionMealDeal;
import src.main.PromotionMultiPrice;
import src.main.PromotionOneFree;
import src.main.TotalPrice;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CheckOutTest{
    static Item itemA;
    static Item itemB;
    static Item itemC;
    static Item itemD;
    static Item itemE;
    static PromotionMultiPrice promotionMultiPrice;
    static PromotionOneFree promotionOneFree;
    static PromotionMealDeal promotionMealDeal;
    static PromotionItems promotionItems;
    static Map<String, Item> map;
    static List<Item> mealDealList;

    
    public static void init(){
        // Inital Items
        itemA = new Item("A", 50);
        itemB = new Item("B", 75);
        itemC = new Item("C", 25);
        itemD = new Item("D", 150);
        itemE = new Item("E", 200);

        map = new HashMap<>();
        map.put("A", itemA);
        map.put("B", itemB);
        map.put("C", itemC);
        map.put("D", itemD);
        map.put("E", itemE);

        mealDealList = new LinkedList<>();
        mealDealList.add(itemD);
        mealDealList.add(itemE);
        
        // Strategy Inital
        promotionMultiPrice = new PromotionMultiPrice(itemB, 2, 25);
        promotionOneFree = new PromotionOneFree(itemC, 3);
        promotionMealDeal = new PromotionMealDeal(mealDealList);
        promotionItems = new PromotionItems();

        // Set Stratgies
        promotionItems.setpromotionSingleTargetRules(promotionMultiPrice);
        promotionItems.setpromotionSingleTargetRules(promotionOneFree);
        promotionItems.setpromotionTargetsRules(promotionMealDeal);

    }

    public static Integer scan(String items){
        CheckOut checkOut = new CheckOut();
        for(int i = 0; i < items.length(); i++) {
            if(map.containsKey(items.substring(i, i+1))){
                checkOut.scanItems(map.get(items.substring(i, i+1)));
            }
        }

        return price(checkOut);
    }

    public static Integer price(CheckOut checkOut){
        ShoppingCart itemsList = checkOut.getItemsList();
        TotalPrice totalPrice = new TotalPrice(itemsList, promotionItems);
        int result = totalPrice.calculatePrice();
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
        assertEquals(Integer.valueOf(300), scan("DE"));
        assertEquals(Integer.valueOf(450), scan("DDE"));
        assertEquals(Integer.valueOf(200), scan("E"));
        assertEquals(Integer.valueOf(400), scan("EE"));
        assertEquals(Integer.valueOf(300), scan("ED"));
        assertEquals(Integer.valueOf(500), scan("EDE"));
        assertEquals(Integer.valueOf(600), scan("EDDE"));
        assertEquals(Integer.valueOf(750), scan("EEDDD"));
        assertEquals(Integer.valueOf(450), scan("ABCDE"));
        assertEquals(Integer.valueOf(500), scan("ABBCDE"));
        assertEquals(Integer.valueOf(675), scan("ABBCCCEDD"));
        assertEquals(Integer.valueOf(550), scan("BCDEBBC"));
        assertEquals(Integer.valueOf(1250), scan("BCCCCDEDEEDDA"));
        assertEquals(Integer.valueOf(300), scan("AAEF"));
        assertEquals(Integer.valueOf(0), scan(""));

    }

    public static void main(String[] args) throws Exception{
        init();
        testPrice();

    }

    
}
