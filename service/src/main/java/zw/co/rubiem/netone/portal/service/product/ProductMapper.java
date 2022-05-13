package zw.co.rubiem.netone.portal.service.product;
import zw.co.rubiem.netone.portal.domain.product.Product;


public interface ProductMapper {
    Product productFromProductRequest(ProductRequest productRequest);

    Product productFromProductUpdateRequest(Product product, ProductUpdateRequest productUpdateRequest);

    ProductDto productDtoFromProduct(Product product);
}
