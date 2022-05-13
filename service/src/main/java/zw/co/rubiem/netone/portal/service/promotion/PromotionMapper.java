package zw.co.rubiem.netone.portal.service.promotion;

import zw.co.rubiem.netone.portal.domain.promotions.promotion.Promotion;

public interface PromotionMapper {

    Promotion promotionFromPromotionRequest(PromotionRequest promotionRequest);

    Promotion promotionFromPromotionUpdateRequest(Promotion promotion, PromotionUpdateRequest promotionUpdateRequest);

    PromotionDto promotionDtoFromPromotion(Promotion promotion);

}
