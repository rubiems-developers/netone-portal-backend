package zw.co.rubiem.netone.portal.product;

import lombok.Data;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryDto;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String imageUrl;
    private String shortDescription;
    private String detailedDescription;
    private ProductCategoryDto productCategoryDto;
}
