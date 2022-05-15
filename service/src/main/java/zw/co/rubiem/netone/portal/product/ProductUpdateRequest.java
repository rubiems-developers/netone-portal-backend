package zw.co.rubiem.netone.portal.product;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Product title is required")
    private String title;
    @NotBlank(message = "Product imageUrl is required")
    private String imageUrl;
    @NotBlank(message = "Product short description is required")
    private String shortDescription;
    @NotBlank(message = "Product detailed description is required")
    private String detailedDescription;
    @NotNull(message = "ProductCategoryId is required")
    private Long productCategoryId;
}
