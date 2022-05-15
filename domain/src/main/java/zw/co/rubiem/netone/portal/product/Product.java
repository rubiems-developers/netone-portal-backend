package zw.co.rubiem.netone.portal.product;

import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;
import zw.co.rubiem.netone.portal.product.category.ProductCategory;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends BaseEntity {

    @NotBlank(message = " Product title  is required")
    @Column(nullable = false)
    @Size(max = 200)
    private String title;

    @NotNull(message = "Product Image is required")
    @Column(nullable = false)
    private String imageUrl;

    @Column(name = "short_description", columnDefinition = "TEXT", length = 2000)
    @NotBlank(message = "Product short description is required")
    private String shortDescription;

    @NotNull(message = "Product category is required!")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_product_category"))
    private ProductCategory productCategory;

    @Column(name = "detailed_description", columnDefinition = "TEXT", length = 2000)
    private String detailedDescription;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String productImage) {
        this.imageUrl = productImage;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String productInfo) {
        this.shortDescription = productInfo;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String productContent) {
        this.detailedDescription = productContent;
    }

}
