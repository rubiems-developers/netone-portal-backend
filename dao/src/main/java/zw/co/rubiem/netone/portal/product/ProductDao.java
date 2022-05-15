package zw.co.rubiem.netone.portal.product;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProductDao extends BaseDao<Product> {
    Optional<Product> findByTitleIgnoreCase(String title);

    Collection<Product> findByProductCategory_Id(long productCategoryId);
}
