package zw.co.rubiem.netone.portal.article.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface ArticleCategoryService extends BaseService<ArticleCategory, ArticleCategoryRequest, ArticleCategoryUpdateRequest> {

    ArticleCategory findByName(String name);

    ArticleCategoryDto findArticleCategoryById(Long id);

    Page<ArticleCategoryDto> findAllArticleCategory(Pageable pageable, String searchQuery);

    Collection<ArticleCategoryDto> findAllArticleCategory();

}
