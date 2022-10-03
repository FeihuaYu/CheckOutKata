package src.main;

import java.util.List;

public interface PromotionRules {
    public int calculatePromotion(int itemQuantity, int itemPrice);
    public int calculatePromotion(List<Integer> itemQuantity);
}
