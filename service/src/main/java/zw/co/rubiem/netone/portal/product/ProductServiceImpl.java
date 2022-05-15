package zw.co.rubiem.netone.portal.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryMapper;
import zw.co.rubiem.netone.portal.product.category.ProductCategoryService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

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
                    dto.setId(product.getId());
                    dto.setTitle(product.getTitle());
                    dto.setImageUrl(product.getImageUrl());
                    dto.setShortDescription(product.getShortDescription());
                    dto.setProductCategoryDto(productCategoryMapper.productCategoryDtoFromProductCategory(product.getProductCategory()));
                    dto.setDetailedDescription(product.getDetailedDescription());
                    return dto;
                });
    }

    @Override
    public Collection<ProductDto> findAllProducts() {
        Collection<Product> productCollection = findAll();
        Collection<ProductDto> productDtos = new ArrayList<>();
        productCollection.forEach(product ->
                productDtos.add(productMapper.productDtoFromProduct(product)));
        return productDtos;
    }

    @Override
    public Collection<ProductDto> findProductsByCategoryId(long productCategoryId) {
        return productDao.findByProductCategory_Id(productCategoryId)
                .stream().map(productMapper::productDtoFromProduct).collect(Collectors.toList());
    }

    @Override
    public Page<Product> findAll(Pageable pageable, String searchQuery) {
        Page<Product> productPage = findAll(pageable, searchQuery);
        return productPage
                .map(product -> {
                    Product product1 = new Product();
                    product1.setTitle(product.getTitle());
                    product1.setImageUrl(product.getImageUrl());
                    product1.setShortDescription(product.getShortDescription());
                    product1.setDetailedDescription(product.getDetailedDescription());
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
