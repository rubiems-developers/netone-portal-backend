package zw.co.rubiem.netone.portal.service.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import zw.co.rubiem.netone.portal.dao.product.ProductDao;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.domain.product.Product;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.service.product.category.ProductCategoryMapper;
import zw.co.rubiem.netone.portal.service.product.category.ProductCategoryService;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductRequest, ProductUpdateRequest> implements ProductService {
    private final ProductDao productDao;
    private final ProductMapper productMapper;
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;
    public ProductServiceImpl(ProductDao productDao,
                              ProductMapper productMapper, ProductCategoryService productCategoryService, ProductCategoryMapper productCategoryMapper) {
        super(productDao);
        this.productDao = productDao;
        this.productMapper = productMapper;
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public Product findByTitle(String name) {
        return productDao.findByTitleIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public ProductDto findProductById(Long id) {
        return productMapper.productDtoFromProduct(findById(id));
    }

    @Override
    public Page<ProductDto> findAllProducts(Pageable pageable, String searchQuery) {
        Page<Product> productPage = findAll(pageable, searchQuery);
        return productPage
                .map(product -> {
                    ProductDto dto = new ProductDto();
                    dto.setTitle(product.getTitle());
                    dto.setProductImage(product.getProductImage());
                    dto.setProductInfo(product.getProductInfo());
                    dto.setProductCategoryDto(productCategoryMapper.productCategoryDtoFromProductCategory(product.getProductCategory()));
                    dto.setProductContent(product.getProductContent());
                    dto.setProductImages(product.getProductImages());
                    return dto;
                });
    }

    @Override
    public Collection<ProductDto> findAllProductsCollections() {
        Collection<Product> productCollection = findAll();
        Collection<ProductDto> productDtos = new ArrayList<>();
        productCollection.forEach(product ->
                productDtos.add(productMapper.productDtoFromProduct(product)));
        return productDtos;
    }

    @Override
    public Page<Product> findAll(java.awt.print.Pageable pageable, String searchQuery) {
        Page<Product> productPage = findAll(pageable, searchQuery);
        return productPage
                .map(product -> {
                    Product product1 = new Product();
                    product1.setTitle(product.getTitle());
                    product1.setProductImage(product.getProductImage());
                    product1.setProductInfo(product.getProductInfo());
                    product1.setProductContent(product.getProductContent());
                    product1.setProductImages(product.getProductImages());
                    return product1;
                });
    }


    @Override
    public Product create(ProductRequest createDto) {
        Optional<Product> optionalProduct = productDao.findByTitleIgnoreCase(createDto.getTitle());
        if (optionalProduct.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }

        Product product = productMapper.productFromProductRequest(createDto);
        ProductCategory productCategory = productCategoryService.findById(createDto.getProductCategoryId());
        product.setProductCategory(productCategory);
        return productDao.save(product);
    }

    @Override
    public Product update(ProductUpdateRequest updateDto) {
        Product productRecord = findById(updateDto.getId());
        Product product = productMapper
                .productFromProductUpdateRequest(productRecord, updateDto);
        ProductCategory productCategory = productCategoryService.findById(updateDto.getId());
        product.setProductCategory(productCategory);
        return productDao.save(product);
    }
}
