package zw.co.rubiem.netone.portal.article.category;

public interface ArticleCategoryMapper {
    ArticleCategory articleCategoryFromArticleCategoryRequest(ArticleCategoryRequest articleCategoryRequest);

    ArticleCategory articleCategoryFromArticleCategoryUpdateRequest(ArticleCategory articleCategory, ArticleCategoryUpdateRequest articleCategoryUpdateRequest);

    ArticleCategoryDto articleCategoryDtoFromArticleCategory(ArticleCategory articleCategory);
}
