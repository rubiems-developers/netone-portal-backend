package zw.co.rubiem.netone.portal.api.product.category;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.product.category.*;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "Products Categories")
@RequestMapping("v1/product-category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryController(ProductCategoryService productCategoryService, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @GetMapping("")
    @ApiOperation("Get ProductCategories")
    public Page<ProductCategoryDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                           @RequestParam(required = false) String search) {
        return productCategoryService.findAllProductCategories(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All ProductCategories")
    public Collection<ProductCategoryDto> getAllA() {
        return productCategoryService.findAllProductCategoryCollections();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a ProductCategory by Id")
    public ProductCategoryDto getProductCategory(@PathVariable long id) {
        return productCategoryService.findProductCategoryById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a ProductCategory by Id")
    public void delete(@PathVariable long id) {
        productCategoryService.delete(id);
    }




    @PostMapping("")
    @ApiOperation("Create ProductCategory")
    public ProductCategoryDto create(@RequestBody ProductCategoryRequest request) {
        return productCategoryMapper.productCategoryDtoFromProductCategory(productCategoryService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ProductCategory")
    public ProductCategoryDto update(@RequestBody ProductCategoryUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return productCategoryMapper.productCategoryDtoFromProductCategory(productCategoryService.update(request));
    }
}
