package zw.co.rubiem.netone.portal.dao.promotion;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.promotions.promotion.Promotion;

import java.util.Optional;

@Repository
public interface PromotionDao extends BaseDao<Promotion> {

    Optional<Promotion> findByTitleIgnoreCase(String title);

}
