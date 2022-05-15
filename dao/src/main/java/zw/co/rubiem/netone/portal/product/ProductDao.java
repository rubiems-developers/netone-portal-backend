package zw.co.rubiem.netone.portal.dao.product;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.product.Product;

import java.util.Optional;

@Repository
public interface ProductDao extends BaseDao<Product> {
    Optional<Product> findByTitleIgnoreCase(String title);
}
