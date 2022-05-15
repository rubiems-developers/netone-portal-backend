package zw.co.rubiem.netone.portal.product.category;

import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class ProductCategory extends BaseEntity {
    @NotBlank(message = "Category name cannot be empty")
    @Column(nullable = false)
    @Size(max = 200)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
