package zw.co.rubiem.netone.portal.article.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;

import java.util.Collection;


@CrossOrigin
@RestController
@Api(tags = "Article Categories")
@RequestMapping("v1/article-category")
public class ArticleCategoryController {

    private final ArticleCategoryService articleCategoryService;

    private final ArticleCategoryMapper articleCategoryMapper;

    public ArticleCategoryController(ArticleCategoryService articleCategoryService, ArticleCategoryMapper articleCategoryMapper) {
        this.articleCategoryService = articleCategoryService;
        this.articleCategoryMapper = articleCategoryMapper;
    }

    @GetMapping("")
    @ApiOperation("Get ArticleCategories")
    public Page<ArticleCategoryDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                           @RequestParam(required = false) String search) {
        return articleCategoryService.findAllArticleCategory(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All ArticleCategories")
    public Collection<ArticleCategoryDto> getAllA() {
        return articleCategoryService.findAllArticleCategory();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a ArticleCategory by Id")
    public ArticleCategoryDto getArticleCategory(@PathVariable long id) {
        return articleCategoryService.findArticleCategoryById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a ArticleCategory by Id")
    public void delete(@PathVariable long id) {
        articleCategoryService.delete(id);
    }


    @PostMapping("")
    @ApiOperation("Create ArticleCategory")
    public ArticleCategoryDto create(@RequestBody ArticleCategoryRequest request) {
        return articleCategoryMapper.articleCategoryDtoFromArticleCategory(articleCategoryService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ArticleCategory")
    public ArticleCategoryDto update(@RequestBody ArticleCategoryUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return articleCategoryMapper.articleCategoryDtoFromArticleCategory(articleCategoryService.update(request));
    }
}
