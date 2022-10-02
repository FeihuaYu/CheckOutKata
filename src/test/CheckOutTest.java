package src.test;

import org.junit.Test;

import src.main.CheckOut;
import src.main.Item;
import src.main.ItemsList;
import src.main.TotalPrice;

import static org.junit.Assert.*;


public class CheckOutTest{

    static Item itemA;
    static Item itemB;
    static Item itemC;
    static Item itemD;
    static Item itemE;

    
    public static void init(){
        itemA = new Item("A", 50);
        itemB = new Item("B", 75);
        itemC = new Item("C", 25);
        itemD = new Item("D", 150);
        itemE = new Item("E", 200);
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
        TotalPrice totalPrice = new TotalPrice(itemsList);
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
        // assertEquals(Integer.valueOf(75), scan("B"));
        // assertEquals(Integer.valueOf(125), scan("BB"));
        // assertEquals(Integer.valueOf(200), scan("BBB"));
        // assertEquals(Integer.valueOf(250), scan("BBBB"));
        // assertEquals(Integer.valueOf(175), price("BAB"));
        // assertEquals(Integer.valueOf(25), price("C"));
        // assertEquals(Integer.valueOf(50), price("CC"));
        // assertEquals(Integer.valueOf(50), price("CCC"));
        // assertEquals(Integer.valueOf(75), price("CCCC"));
        // assertEquals(Integer.valueOf(100), price("CCCCC"));
        // assertEquals(Integer.valueOf(100), price("CCCCCC"));
        // assertEquals(Integer.valueOf(150), price("D"));
        // assertEquals(Integer.valueOf(300), price("DD"));
        // assertEquals(Integer.valueOf(300), price("DE"));
        // assertEquals(Integer.valueOf(450), price("DDE"));
        // assertEquals(Integer.valueOf(200), price("E"));
        // assertEquals(Integer.valueOf(400), price("EE"));
        // assertEquals(Integer.valueOf(300), price("ED"));
        // assertEquals(Integer.valueOf(500), price("EDE"));
        // assertEquals(Integer.valueOf(600), price("EDDE"));
        // assertEquals(Integer.valueOf(750), price("EEDDD"));
    }

    public static void main(String[] args) throws Exception{
        init();
        testPrice();

    }

    
}
