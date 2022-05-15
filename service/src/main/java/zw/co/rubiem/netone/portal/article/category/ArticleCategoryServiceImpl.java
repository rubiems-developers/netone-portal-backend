package zw.co.rubiem.netone.portal.article.category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategory, ArticleCategoryRequest, ArticleCategoryUpdateRequest> implements ArticleCategoryService {

    private final ArticleCategoryDao articleCategoryDao;

    private final ArticleCategoryMapper articleCategoryMapper;

    public ArticleCategoryServiceImpl(ArticleCategoryDao articleCategoryDao, ArticleCategoryMapper articleCategoryMapper) {
        super(articleCategoryDao);
        this.articleCategoryDao = articleCategoryDao;
        this.articleCategoryMapper = articleCategoryMapper;
    }

    @Override
    protected Class<ArticleCategory> getEntityClass() {
        return ArticleCategory.class;
    }

    @Override
    public Page<ArticleCategory> findAll(Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    public ArticleCategory create(ArticleCategoryRequest createDto) {
        Optional<ArticleCategory> optionalArticleCategory = articleCategoryDao.findByNameIgnoreCase(createDto.getName());
        if (optionalArticleCategory.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        ArticleCategory articleCategory = articleCategoryMapper
                .articleCategoryFromArticleCategoryRequest(createDto);
        return articleCategoryDao.save(articleCategory);
    }

    @Override
    public ArticleCategory update(ArticleCategoryUpdateRequest updateDto) {
        ArticleCategory articleCategoryRecord = findById(updateDto.getId());
        ArticleCategory articleCategory = articleCategoryMapper
                .articleCategoryFromArticleCategoryUpdateRequest(articleCategoryRecord, updateDto);
        return articleCategoryDao.save(articleCategory);
    }

    @Override
    public ArticleCategory findByName(String name) {
        return articleCategoryDao.findByNameIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }
@Override
public ArticleCategoryDto findArticleCategoryById(Long id){
        return  articleCategoryMapper.articleCategoryDtoFromArticleCategory(findById(id));
}



    @Override
    public Page<ArticleCategoryDto> findAllArticleCategory(Pageable pageable, String searchQuery) {
        Page<ArticleCategory> articleCategoryPage = findAll(pageable, searchQuery);
        return articleCategoryPage
                .map(articleCategory -> {
                    ArticleCategoryDto dto = new ArticleCategoryDto();
                    dto.setId(articleCategory.getId());
                    dto.setName(articleCategory.getName());
                    return dto;
                });
    }

    @Override
    public Collection<ArticleCategoryDto> findAllArticleCategory() {
        Collection<ArticleCategory> articleCategories = findAll();
        Collection<ArticleCategoryDto> articleCategoryDtos = new ArrayList<>();
        articleCategories.forEach(articleCategory ->
                articleCategoryDtos.add(articleCategoryMapper.articleCategoryDtoFromArticleCategory(articleCategory)));
        return articleCategoryDtos;
    }



}
