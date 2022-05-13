package zw.co.rubiem.netone.portal.service.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.article.Article;

import java.util.Collection;

public interface ArticleService extends BaseService<Article, ArticleRequest, ArticleUpdateRequest> {

    Article findByTitle(String name);

    ArticleDto findArticleById(Long id);

    Page<ArticleDto> findAllArticle(Pageable pageable, String searchQuery);

    Collection<ArticleDto> findAllArticle();

}
