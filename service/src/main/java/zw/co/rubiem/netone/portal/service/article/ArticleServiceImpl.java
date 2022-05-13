package zw.co.rubiem.netone.portal.service.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.dao.article.ArticleDao;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.service.article.category.ArticleCategoryMapper;
import zw.co.rubiem.netone.portal.domain.article.Article;
import zw.co.rubiem.netone.portal.domain.article.category.ArticleCategory;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.service.article.category.ArticleCategoryService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, ArticleRequest, ArticleUpdateRequest> implements ArticleService {

    private final ArticleDao articleDao;
    private final ArticleMapper articleMapper;
    private final ArticleCategoryService articleCategoryService;
    private final ArticleCategoryMapper articleCategoryMapper;

    public ArticleServiceImpl(ArticleDao articleDao,
                              ArticleMapper articleMapper, ArticleCategoryService articleCategoryService, ArticleCategoryMapper articleCategoryMapper) {
        super(articleDao);
        this.articleDao = articleDao;
        this.articleMapper = articleMapper;
        this.articleCategoryService = articleCategoryService;
        this.articleCategoryMapper = articleCategoryMapper;
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

    @Override
    public Page<Article> findAll(java.awt.print.Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    @Transactional
    public Article create(ArticleRequest createDto) {
        Optional<Article> optionalArticle = articleDao.findByTitleIgnoreCase(createDto.getTitle());
        if (optionalArticle.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        Article article = articleMapper
                .articleFromArticleRequest(createDto);
        ArticleCategory articleCategory = articleCategoryService.findById(createDto.getArticleCategoryId());
        article.setArticleCategory(articleCategory);
        return articleDao.save(article);
    }

    @Override
    @Transactional
    public Article update(ArticleUpdateRequest updateDto) {
        Article articleRecord = findById(updateDto.getId());
        Article article = articleMapper
                .articleFromArticleUpdateRequest(articleRecord, updateDto);
        ArticleCategory articleCategory = articleCategoryService.findById(updateDto.getArticleCategoryId());
        article.setArticleCategory(articleCategory);
        return articleDao.save(article);
    }

    @Override
    public Article findByTitle(String name) {
        return articleDao.findByTitleIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public ArticleDto findArticleById(Long id) {
        return articleMapper.articleDtoFromArticle(findById(id));
    }

    @Override
    public Page<ArticleDto> findAllArticle(Pageable pageable, String searchQuery) {
        Page<Article> articlePage = findAll(pageable, searchQuery);
        return articlePage
                .map(article -> {
                    ArticleDto dto = new ArticleDto();
                    dto.setId(article.getId());
                    dto.setTitle(article.getTitle());
                    dto.setDescription(article.getDescription());
                    dto.setArticleCategory(articleCategoryMapper.articleCategoryDtoFromArticleCategory(article.getArticleCategory()));
                    return dto;
                });
    }

    @Override
    public Collection<ArticleDto> findAllArticle() {
        Collection<Article> articleCategories = findAll();
        Collection<ArticleDto> articleDtos = new ArrayList<>();
        articleCategories.forEach(article ->
                articleDtos.add(articleMapper.articleDtoFromArticle(article)));
        return articleDtos;
    }



}
