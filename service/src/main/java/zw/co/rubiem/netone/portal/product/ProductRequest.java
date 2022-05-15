package zw.co.rubiem.netone.portal.product;
import lombok.Data;

import javax.persistence.Lob;

@Data
public class ProductRequest {
    private String title;
    private byte[] productImage;
    @Lob
    private String productInfo;
    @Lob
    private String productContent;
    private byte[] productImages;
    private Long productCategoryId;

}
