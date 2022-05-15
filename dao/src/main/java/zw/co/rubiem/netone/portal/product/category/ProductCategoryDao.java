package zw.co.rubiem.netone.portal.product.category;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;
@Repository
public interface ProductCategoryDao extends BaseDao<ProductCategory> {
    Optional<ProductCategory> findByNameIgnoreCase(String name);

}
