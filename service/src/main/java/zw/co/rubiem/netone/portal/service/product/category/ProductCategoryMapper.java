package zw.co.rubiem.netone.portal.service.product.category;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;


public interface ProductCategoryMapper {
    ProductCategory productCategoryFromProductCategoryRequest(ProductCategoryRequest productCategoryRequest);

    ProductCategory productCategoryFromProductCategoryUpdateRequest(ProductCategory productCategory, ProductCategoryUpdateRequest productCategoryUpdateRequest);

    ProductCategoryDto productCategoryDtoFromProductCategory(ProductCategory productCategory);
}
