package zw.co.rubiem.netone.portal.service.article.category;

import zw.co.rubiem.netone.portal.domain.article.category.ArticleCategory;

public interface ArticleCategoryMapper {
    ArticleCategory articleCategoryFromArticleCategoryRequest(ArticleCategoryRequest articleCategoryRequest);

    ArticleCategory articleCategoryFromArticleCategoryUpdateRequest(ArticleCategory articleCategory, ArticleCategoryUpdateRequest articleCategoryUpdateRequest);

    ArticleCategoryDto articleCategoryDtoFromArticleCategory(ArticleCategory articleCategory);
}
