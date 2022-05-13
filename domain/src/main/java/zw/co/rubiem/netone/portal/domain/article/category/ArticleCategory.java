package zw.co.rubiem.netone.portal.domain.article.category;

import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class ArticleCategory extends BaseEntity {
    @NotBlank(message = "Article category name cannot be empty")
    @Size(min = 3, max = 100)
    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
