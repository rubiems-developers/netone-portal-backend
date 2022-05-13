package zw.co.rubiem.netone.portal.service.product;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import zw.co.rubiem.netone.portal.service.product.category.ProductCategoryDto;

import javax.persistence.Lob;
import java.util.List;

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
