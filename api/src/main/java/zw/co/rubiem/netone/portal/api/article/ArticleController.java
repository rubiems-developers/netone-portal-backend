package zw.co.rubiem.netone.portal.api.article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.service.article.*;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.InvalidRequestException;

import java.util.Collection;


@CrossOrigin
@RestController
@Api(tags = "Articles")
@RequestMapping("v1/article")
public class ArticleController {
    private final ArticleService articleService;

    private final ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @GetMapping("")
    @ApiOperation("Get Articles")
    public Page<ArticleDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                   @RequestParam(required = false) String search) {
        return articleService.findAllArticle(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All Articles")
    public Collection<ArticleDto> getAll() {
        return articleService.findAllArticle();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a Article by Id")
    public ArticleDto getArticle(@PathVariable long id) {
        return articleService.findArticleById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Article by Id")
    public void delete(@PathVariable long id) {
        articleService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create Article")
    public ArticleDto create(@RequestBody ArticleRequest request) {
        return articleMapper.articleDtoFromArticle(articleService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Article")
    public ArticleDto update(@RequestBody ArticleUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return articleMapper.articleDtoFromArticle(articleService.update(request));
    }

}
