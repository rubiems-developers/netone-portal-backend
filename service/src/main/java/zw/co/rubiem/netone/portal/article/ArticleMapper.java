package zw.co.rubiem.netone.portal.article;

public interface ArticleMapper {
    Article articleFromArticleRequest(ArticleRequest planRequest);

    Article articleFromArticleUpdateRequest(Article article, ArticleUpdateRequest articleUpdateRequest);

    ArticleDto articleDtoFromArticle(Article article);
}
