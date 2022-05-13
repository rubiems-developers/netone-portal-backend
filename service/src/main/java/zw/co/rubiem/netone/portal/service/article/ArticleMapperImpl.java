package zw.co.rubiem.netone.portal.service.article;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.service.article.category.ArticleCategoryMapper;
import zw.co.rubiem.netone.portal.domain.article.Article;

import java.util.Objects;

@Component
public class ArticleMapperImpl implements ArticleMapper {

    private final ArticleCategoryMapper articleCategoryMapper;

    public ArticleMapperImpl(ArticleCategoryMapper articleCategoryMapper) {
        this.articleCategoryMapper = articleCategoryMapper;
    }

    @Override
    public Article articleFromArticleRequest(ArticleRequest articleRequest) {
        Objects.requireNonNull(articleRequest, "ArticleRequest must not be null");
        Article article = new Article();
        article.setTitle(articleRequest.getTitle());
        article.setDescription(articleRequest.getDescription());
        article.setTags(articleRequest.getTags());
        return article;
    }

    @Override
    public Article articleFromArticleUpdateRequest(Article article, ArticleUpdateRequest articleUpdateRequest) {
        Objects.requireNonNull(article, "Article must not be null");
        Objects.requireNonNull(articleUpdateRequest, "ArticleUpdateRequest must not be null");
        article.setTitle(articleUpdateRequest.getTitle());
        article.setArticleCategory(articleUpdateRequest.getArticleCategory());
        article.setDescription(articleUpdateRequest.getDescription());
        article.setTags(articleUpdateRequest.getTags());
        return article;
    }

    @Override
    public ArticleDto articleDtoFromArticle(Article article) {
        Objects.requireNonNull(article, "Article must not be null");
        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTitle(article.getTitle());
        articleDto.setDescription(article.getDescription());
        articleDto.setTags(article.getTags());
        articleDto.setArticleCategory(articleCategoryMapper.articleCategoryDtoFromArticleCategory(article.getArticleCategory()));
        return articleDto;
    }

}
