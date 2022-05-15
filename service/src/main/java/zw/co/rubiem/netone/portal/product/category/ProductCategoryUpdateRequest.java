package zw.co.rubiem.netone.portal.product.category;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductCategoryUpdateRequest {
    @NotNull(message = "id is required")
    private Long id ;
    @NotNull(message = "name is required")
    private String name;
    private String description;
}
