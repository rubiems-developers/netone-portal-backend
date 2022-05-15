package zw.co.rubiem.netone.portal.product;

import lombok.Data;
import zw.co.rubiem.netone.portal.product.category.ProductCategory;

import javax.validation.constraints.NotNull;

@Data
public class ProductUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "productImage is required")
    private byte[] productImage;

    @NotNull(message = "productCategoryDto is required")
    private ProductCategory productCategory;

    @NotNull(message = "productContent is required")
    private String productInfo;

    @NotNull(message = "Id is required")
    private String productContent;

    @NotNull(message = "productImages is required")
    private byte[] productImages;

}
