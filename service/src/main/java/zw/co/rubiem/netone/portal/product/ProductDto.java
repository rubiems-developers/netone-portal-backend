package zw.co.rubiem.netone.portal.product;
import lombok.Data;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryDto;

import javax.persistence.Lob;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private byte[] productImage;
    private ProductCategoryDto productCategoryDto;
    @Lob
    private String productInfo;
    @Lob
    private String productContent;
    private byte[] productImages;

}
