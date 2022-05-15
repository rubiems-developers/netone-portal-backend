package zw.co.rubiem.netone.portal.promotion;

import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.promotions.promotion.Promotion;

import java.util.Objects;

@Service
public class PromotionMapperImpl implements PromotionMapper {

    @Override
    public Promotion promotionFromPromotionRequest(PromotionRequest promotionRequest) {
        Promotion promotion = new Promotion();
        promotion.setTitle(promotionRequest.getTitle());
        promotion.setDescription(promotionRequest.getDescription());
        promotion.setImageUrl(promotionRequest.getImageUrl());
        promotion.setStartDate(promotionRequest.getStartDate());
        promotion.setEndDate(promotionRequest.getEndDate());
        return promotion;
    }

    @Override
    public Promotion promotionFromPromotionUpdateRequest(Promotion promotion, PromotionUpdateRequest promotionUpdateRequest) {
        Objects.requireNonNull(promotion, "Promotion must not be null");
        Objects.requireNonNull(promotionUpdateRequest, "PromotionUpdateRequest must not be null");
        promotion.setTitle(promotionUpdateRequest.getTitle());
        promotion.setDescription(promotionUpdateRequest.getDescription());
        promotion.setImageUrl(promotionUpdateRequest.getImageUrl());
        promotion.setStartDate(promotionUpdateRequest.getStartDate());
        promotion.setEndDate(promotionUpdateRequest.getEndDate());
        return promotion;
    }

    @Override
    public PromotionDto promotionDtoFromPromotion(Promotion promotion) {
        Objects.requireNonNull(promotion, "Promotion must not be null");
        PromotionDto promotionDto = new PromotionDto();
        promotionDto.setTitle(promotion.getTitle());
        promotionDto.setDescription(promotion.getDescription());
        promotionDto.setImageUrl(promotion.getImageUrl());
        promotionDto.setStartDate(promotion.getStartDate());
        promotionDto.setEndDate(promotion.getEndDate());
        return promotionDto;
    }

}
