package zw.co.rubiem.netone.portal.service.article;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.article.category.ArticleCategory;

import javax.persistence.Lob;

@Data
public class ArticleUpdateRequest {

    private Long id;

    private String title;
    @Lob
    private String description;

    public String tags;
    private ArticleCategory articleCategory;
    private Long articleCategoryId;

}
