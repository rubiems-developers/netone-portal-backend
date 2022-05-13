package zw.co.rubiem.netone.portal.dao.product.category;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.domain.promotions.promotion.Promotion;

import java.util.Optional;
@Repository
public interface ProductCategoryDao extends BaseDao<ProductCategory> {
    Optional<ProductCategory> findByNameIgnoreCase(String name);

}
