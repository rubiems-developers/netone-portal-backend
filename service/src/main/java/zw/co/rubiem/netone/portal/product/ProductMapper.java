package zw.co.rubiem.netone.portal.product;


public interface ProductMapper {
    Product productFromProductRequest(ProductRequest productRequest);

    Product productFromProductUpdateRequest(Product product, ProductUpdateRequest productUpdateRequest);

    ProductDto productDtoFromProduct(Product product);
}
