package zw.co.rubiem.netone.portal.promotion;

import zw.co.rubiem.netone.portal.promotions.promotion.Promotion;

public interface PromotionMapper {

    Promotion promotionFromPromotionRequest(PromotionRequest promotionRequest);

    Promotion promotionFromPromotionUpdateRequest(Promotion promotion, PromotionUpdateRequest promotionUpdateRequest);

    PromotionDto promotionDtoFromPromotion(Promotion promotion);

}
