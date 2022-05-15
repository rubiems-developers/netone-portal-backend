package zw.co.rubiem.netone.portal.product.category;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper{
    @Override
    public ProductCategory productCategoryFromProductCategoryRequest(ProductCategoryRequest productCategoryRequest) {
        Objects.requireNonNull(productCategoryRequest, "ProductCategoryRequest must not be null");
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryRequest.getName());
        return productCategory;
    }

    @Override
    public ProductCategory productCategoryFromProductCategoryUpdateRequest(ProductCategory productCategory, ProductCategoryUpdateRequest productCategoryUpdateRequest) {
        Objects.requireNonNull(productCategoryUpdateRequest, "ProductCategory must not be null");
        Objects.requireNonNull(productCategoryUpdateRequest, "ProductCategoryUpdateRequest must not be null");
        productCategory.setName(productCategoryUpdateRequest.getName());
        return productCategory;
    }

    @Override
    public ProductCategoryDto productCategoryDtoFromProductCategory(ProductCategory productCategory) {
        Objects.requireNonNull(productCategory, "ProductCategory must not be null");
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setName(productCategory.getName());
        return productCategoryDto;
    }
}
