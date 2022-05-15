package zw.co.rubiem.netone.portal.product;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryMapper;

import java.util.Objects;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final ProductCategoryMapper productCategoryMapper;

    public ProductMapperImpl(ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public Product productFromProductRequest(ProductRequest productRequest) {
        Objects.requireNonNull(productRequest, "ProductRequest must not be null");
        Product product = new Product();
        product.setTitle(productRequest.getTitle());
        product.setImageUrl(productRequest.getImageUrl());
        product.setShortDescription(productRequest.getShortDescription());
        product.setDetailedDescription(productRequest.getDetailedDescription());
        return product;
    }

    @Override
    public Product productFromProductUpdateRequest(Product product, ProductUpdateRequest productUpdateRequest) {
        Objects.requireNonNull(product, "Product must not be null");
        Objects.requireNonNull(productUpdateRequest, "ProductUpdateRequest must not be null");
        product.setTitle(productUpdateRequest.getTitle());
        product.setImageUrl(productUpdateRequest.getImageUrl());
        product.setShortDescription(productUpdateRequest.getShortDescription());
        product.setDetailedDescription(productUpdateRequest.getDetailedDescription());
        return product;
    }

    @Override
    public ProductDto productDtoFromProduct(Product product) {
        Objects.requireNonNull(product, "Product must not be null");
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setShortDescription(product.getShortDescription());
        productDto.setProductCategoryDto(productCategoryMapper.productCategoryDtoFromProductCategory(product.getProductCategory()));
        productDto.setDetailedDescription(product.getDetailedDescription());
        return productDto;
    }
}
