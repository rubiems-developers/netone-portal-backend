package zw.co.rubiem.netone.portal.service.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.service.product.category.ProductCategoryDto;

import javax.validation.constraints.NotNull;
import java.util.List;

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
