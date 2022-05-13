package zw.co.rubiem.netone.portal.service.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.dao.promotion.PromotionDao;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.domain.job.Job;
import zw.co.rubiem.netone.portal.domain.product.Product;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.domain.promotions.promotion.Promotion;
import zw.co.rubiem.netone.portal.service.job.JobDto;
import zw.co.rubiem.netone.portal.service.product.ProductDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class PromotionServiceImpl extends BaseServiceImpl<Promotion, PromotionRequest, PromotionUpdateRequest> implements PromotionService {

    private final PromotionDao promotionDao;
    private final PromotionMapper promotionMapper;

    public PromotionServiceImpl(PromotionDao promotionDao, PromotionMapper promotionMapper) {
        super(promotionDao);
        this.promotionDao = promotionDao;
        this.promotionMapper = promotionMapper;
    }

    @Override
    protected Class<Promotion> getEntityClass() {
        return Promotion.class;
    }

    @Override
    public PromotionDto findPromotionById(Long id) {
        return promotionMapper.promotionDtoFromPromotion(findById(id));

    }

    @Override
    public Page<PromotionDto> findAllPromotions(Pageable pageable, String searchQuery) {
        return  null;
    }

    @Override
    public Collection<PromotionDto> findAllPromotions() {
        Collection<Promotion> promotionCollection = findAll();
        Collection<PromotionDto> promotionDtos = new ArrayList<>();
        promotionCollection.forEach(product ->
                promotionDtos.add(promotionMapper.promotionDtoFromPromotion(product)));
        return promotionDtos;
    }

    @Override
    public PromotionDto updatePromotion(PromotionUpdateRequest promotionUpdateRequest) {
        return null;
    }

    @Override
    public Page<Promotion> findAll(java.awt.print.Pageable pageable, String searchQuery) {
        Page<Promotion> promotionPage = findAll(pageable, searchQuery);
        return promotionPage
                .map(promotion -> {
                    Promotion promotion1 = new Promotion();
                    promotion1.setTitle(promotion.getTitle());
                    promotion1.setDescription(promotion.getDescription());
                    promotion1.setImageUrl(promotion.getImageUrl());
                    promotion1.setStartDate(promotion.getStartDate());
                    promotion1.setEndDate(promotion.getEndDate());
                    return promotion1;
                });
    }

    @Override
    public Promotion create(PromotionRequest createDto) {
        Optional<Promotion> optionalPromotion = promotionDao.findByTitleIgnoreCase(createDto.getTitle());
        if (optionalPromotion.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        Promotion promotion = promotionMapper.promotionFromPromotionRequest(createDto);
        return promotionDao.save(promotion);

    }

    @Override
    public Promotion update(PromotionUpdateRequest updateDto) {
        Promotion promotionRecord = findById(updateDto.getId());
        Promotion promotion = promotionMapper
                .promotionFromPromotionUpdateRequest(promotionRecord, updateDto);
        return promotionDao.save(promotion);
    }
}
