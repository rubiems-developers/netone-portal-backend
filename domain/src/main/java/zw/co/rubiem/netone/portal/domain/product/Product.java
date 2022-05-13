package zw.co.rubiem.netone.portal.domain.product;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product extends BaseEntity{

    @NotBlank(message = " Product title  cannot be empty")
    @Column(nullable = false)
    @Size( max = 200)
    private String title;

    @NotBlank(message = "ProductImage  cannot be empty")
    @Column(nullable = false)
    private byte[] productImage;

    @Lob
    @Column(nullable = true)
    @NotBlank(message = "ProductInfo  cannot be empty")
    private String productInfo;

    @NotNull(message = "Product category cannot be empty!")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_product_category"))
    private ProductCategory productCategory;
    @Lob
    @Column(nullable = true)
    private String productContent;

    @Column(nullable = true)
    private byte[] productImages;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getProductImage() {
        return this.productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductContent() {
        return productContent;
    }

    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }

    public byte[] getProductImages() {
        return productImages;
    }

    public void setProductImages(byte[] productImages) {
        this.productImages = productImages;
    }
}
