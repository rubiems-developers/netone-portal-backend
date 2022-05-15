package zw.co.rubiem.netone.portal.product.category;


public interface ProductCategoryMapper {
    ProductCategory productCategoryFromProductCategoryRequest(ProductCategoryRequest productCategoryRequest);

    ProductCategory productCategoryFromProductCategoryUpdateRequest(ProductCategory productCategory, ProductCategoryUpdateRequest productCategoryUpdateRequest);

    ProductCategoryDto productCategoryDtoFromProductCategory(ProductCategory productCategory);
}
