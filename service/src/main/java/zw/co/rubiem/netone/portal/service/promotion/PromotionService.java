package zw.co.rubiem.netone.portal.service.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.promotions.promotion.Promotion;

import java.util.Collection;

public interface PromotionService extends BaseService<Promotion, PromotionRequest, PromotionUpdateRequest> {

    PromotionDto findPromotionById(Long id);

    Page<PromotionDto> findAllPromotions(Pageable pageable, String searchQuery);

    Collection<PromotionDto> findAllPromotions();

    PromotionDto updatePromotion(PromotionUpdateRequest promotionUpdateRequest);

}
