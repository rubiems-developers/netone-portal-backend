package zw.co.rubiem.netone.portal.article;

import lombok.Data;
import zw.co.rubiem.netone.portal.article.category.ArticleCategoryDto;

import javax.persistence.Lob;

@Data
public class ArticleDto {
    private Long id;

    private String title;
    @Lob
    private String description;

    private String tags;

    private ArticleCategoryDto articleCategory;
}
