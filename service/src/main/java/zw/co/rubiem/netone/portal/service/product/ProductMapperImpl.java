package zw.co.rubiem.netone.portal.service.product;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.product.Product;
import zw.co.rubiem.netone.portal.service.product.category.ProductCategoryMapper;

import java.util.Objects;

@Component
public class ProductMapperImpl implements ProductMapper{

    private final ProductCategoryMapper productCategoryMapper;

    public ProductMapperImpl(ProductCategoryMapper productCategoryMapper) {
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public Product productFromProductRequest(ProductRequest productRequest) {
        Product product = new Product();
        product.setTitle(productRequest.getTitle());
        product.setProductImage(productRequest.getProductImage());
        product.setProductInfo(productRequest.getProductInfo());
        product.setProductContent(productRequest.getProductContent());
        product.setProductImages(productRequest.getProductImages());
        return product;
    }

    @Override
    public Product productFromProductUpdateRequest(Product product, ProductUpdateRequest productUpdateRequest) {
        Objects.requireNonNull(product, "Product must not be null");
        Objects.requireNonNull(productUpdateRequest, "ProductUpdateRequest must not be null");
        product.setTitle(productUpdateRequest.getTitle());
        product.setProductImage(productUpdateRequest.getProductImage());
        product.setProductInfo(productUpdateRequest.getProductInfo());
        product.setProductCategory(productUpdateRequest.getProductCategory());
        product.setProductContent(productUpdateRequest.getProductContent());
        product.setProductImages(productUpdateRequest.getProductImages());
        return product;
    }

    @Override
    public ProductDto productDtoFromProduct(Product product) {
        Objects.requireNonNull(product, "Product must not be null");
        ProductDto productDto = new ProductDto();
        productDto.setTitle(product.getTitle());
        productDto.setProductImage(product.getProductImage());
        productDto.setProductInfo(product.getProductInfo());
        productDto.setProductCategoryDto(productCategoryMapper.productCategoryDtoFromProductCategory(product.getProductCategory()));
        productDto.setProductContent(product.getProductContent());
        productDto.setProductImages(product.getProductImages());
        return productDto;
    }
}
