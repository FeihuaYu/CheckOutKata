package src.main;
import java.util.List;
import java.util.LinkedList;
public class PromotionItems {
    private List<PromotionRules> promotionSingleTargetRules = new LinkedList<>();
    private List<PromotionRules> promotionTargetsRules = new LinkedList<>();

    public List<PromotionRules> getSingleTargetStratgies() {
        return promotionSingleTargetRules;
    }

    public List<PromotionRules> getTargetsStratgies() {
        return promotionTargetsRules;
    }

    public void setpromotionSingleTargetRules(PromotionRules promotionalSingleTargetRule) {
        this.promotionSingleTargetRules.add(promotionalSingleTargetRule);
    }


    public void setpromotionTargetsRules(PromotionRules promotionTargetsRules) {
        this.promotionTargetsRules.add(promotionTargetsRules);
    }
    
}
