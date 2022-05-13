package zw.co.rubiem.netone.portal.service.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.product.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


public interface ProductService extends BaseService<Product, ProductRequest, ProductUpdateRequest> {
    Product findByTitle(String name);

    ProductDto findProductById(Long id);

    Page<ProductDto> findAllProducts(Pageable pageable, String searchQuery);

    Collection<ProductDto> findAllProductsCollections();

    Product create(ProductRequest createDto);
}
