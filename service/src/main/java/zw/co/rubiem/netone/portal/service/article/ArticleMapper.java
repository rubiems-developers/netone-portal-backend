package zw.co.rubiem.netone.portal.service.article;

import zw.co.rubiem.netone.portal.domain.article.Article;

public interface ArticleMapper {
    Article articleFromArticleRequest(ArticleRequest planRequest);

    Article articleFromArticleUpdateRequest(Article article, ArticleUpdateRequest articleUpdateRequest);

    ArticleDto articleDtoFromArticle(Article article);
}
