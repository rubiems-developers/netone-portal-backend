package zw.co.rubiem.netone.portal.article;

import zw.co.rubiem.netone.portal.article.category.ArticleCategory;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Article extends BaseEntity {
    @NotBlank(message = "Article title cannot be empty")
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 200)
    private String title;

    @Lob
    @NotBlank(message = "Description cannot be empty")
    @Column(nullable = false)
    private String description;

    private String tags;

    @NotNull(message = "Article category cannot be empty!")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_article_category"))
    private ArticleCategory articleCategory;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public ArticleCategory getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(ArticleCategory articleCategory) {
        this.articleCategory = articleCategory;
    }

}
