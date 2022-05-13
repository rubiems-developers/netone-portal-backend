package zw.co.rubiem.netone.portal.service.product.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;


import java.util.Collection;

public interface ProductCategoryService extends BaseService<ProductCategory, ProductCategoryRequest, ProductCategoryUpdateRequest> {
    ProductCategory findByName(String name);

    ProductCategoryDto findProductCategoryById(Long id);

    Page<ProductCategoryDto> findAllProductCategories(Pageable pageable, String searchQuery);

    Collection<ProductCategoryDto> findAllProductCategoryCollections();
}
