package zw.co.rubiem.netone.portal.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;


public interface ProductService extends BaseService<Product, ProductRequest, ProductUpdateRequest> {
    Product findByTitle(String name);

    ProductDto findProductById(Long id);

    Page<ProductDto> findAllProducts(Pageable pageable, String searchQuery);

    Collection<ProductDto> findAllProducts();

    Collection<ProductDto> findProductsByCategoryId(long productCategoryId);

}
