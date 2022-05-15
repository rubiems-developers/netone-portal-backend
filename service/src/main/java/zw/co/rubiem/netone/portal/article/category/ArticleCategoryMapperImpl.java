package zw.co.rubiem.netone.portal.article.category;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ArticleCategoryMapperImpl implements ArticleCategoryMapper {

    @Override
    public ArticleCategory articleCategoryFromArticleCategoryRequest(ArticleCategoryRequest articleCategoryRequest) {
        Objects.requireNonNull(articleCategoryRequest, "ArticleCategoryRequest must not be null");
        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setName(articleCategoryRequest.getName());
        return articleCategory;
    }

    @Override
    public ArticleCategory articleCategoryFromArticleCategoryUpdateRequest(ArticleCategory articleCategory, ArticleCategoryUpdateRequest articleCategoryUpdateRequest) {
        Objects.requireNonNull(articleCategoryUpdateRequest, "ArticleCategory must not be null");
        Objects.requireNonNull(articleCategoryUpdateRequest, "ArticleCategoryUpdateRequest must not be null");
        articleCategory.setName(articleCategoryUpdateRequest.getName());
        return articleCategory;
    }

    @Override
    public ArticleCategoryDto articleCategoryDtoFromArticleCategory(ArticleCategory articleCategory) {
        Objects.requireNonNull(articleCategory, "ArticleCategory must not be null");
        ArticleCategoryDto articleCategoryDto = new ArticleCategoryDto();
        articleCategoryDto.setId(articleCategory.getId());
        articleCategoryDto.setName(articleCategory.getName());
        return articleCategoryDto;
    }

}
