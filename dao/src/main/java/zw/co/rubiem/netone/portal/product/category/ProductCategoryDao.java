package zw.co.rubiem.netone.portal.dao.product.category;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.product.category.ProductCategory;

import java.util.Optional;
@Repository
public interface ProductCategoryDao extends BaseDao<ProductCategory> {
    Optional<ProductCategory> findByNameIgnoreCase(String name);

}
