package zw.co.rubiem.netone.portal.article;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class ArticleRequest {

    private String title;
    @Lob
    private String description;

    private String tags;

    private Long articleCategoryId;

}
