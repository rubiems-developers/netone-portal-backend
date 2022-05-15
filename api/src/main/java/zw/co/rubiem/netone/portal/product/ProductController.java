package zw.co.rubiem.netone.portal.product;

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
@Api(tags = "Products")
@RequestMapping("v1/product")
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("")
    @ApiOperation("Get Products")
    public Page<ProductDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                   @RequestParam(required = false) String search) {
        return productService.findAllProducts(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All Products")
    public Collection<ProductDto> getAll() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a Product by Id")
    public ProductDto getProduct(@PathVariable long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/by-category-id/{categoryId}/all")
    @ApiOperation("Get All Products By CategoryId")
    public Collection<ProductDto> findProductsByCategoryId(@PathVariable long categoryId) {
        return productService.findProductsByCategoryId(categoryId);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Product by Id")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create Product")
    public ProductDto create(@RequestBody ProductRequest request) {
        return productMapper.productDtoFromProduct(productService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Product")
    public ProductDto update(@RequestBody ProductUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return productMapper.productDtoFromProduct(productService.update(request));
    }

}
