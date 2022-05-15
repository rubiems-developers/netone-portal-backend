package zw.co.rubiem.netone.portal.product.category;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductCategoryRequest {
    @NotBlank(message = "ProductCategory name is required")
    private String name;
    private String description;
}
