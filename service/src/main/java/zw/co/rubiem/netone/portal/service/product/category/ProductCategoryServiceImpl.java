package zw.co.rubiem.netone.portal.service.product.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.dao.product.category.ProductCategoryDao;
import zw.co.rubiem.netone.portal.domain.article.category.ArticleCategory;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.domain.product.category.ProductCategory;
import zw.co.rubiem.netone.portal.service.article.category.ArticleCategoryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl  extends BaseServiceImpl<ProductCategory, ProductCategoryRequest, ProductCategoryUpdateRequest> implements ProductCategoryService {
    private final ProductCategoryDao productCategoryDao;

    private final ProductCategoryMapper productCategoryMapper;



    public ProductCategoryServiceImpl(ProductCategoryDao productCategoryDao, ProductCategoryMapper productCategoryMapper) {
        super(productCategoryDao);
        this.productCategoryDao = productCategoryDao;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public ProductCategory findByName(String name) {
        return productCategoryDao.findByNameIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public ProductCategoryDto findProductCategoryById(Long id) {
        return  productCategoryMapper.productCategoryDtoFromProductCategory(findById(id));

    }

    @Override
    public Page<ProductCategoryDto> findAllProductCategories(Pageable pageable, String searchQuery) {
        Page<ProductCategoryDto> productCategoryDtoPage = findAllProductCategories(pageable, searchQuery);
        return productCategoryDtoPage
                .map(productCategoryDto -> {
                    ProductCategoryDto dto = new ProductCategoryDto();
                    dto.setId(productCategoryDto.getId());
                    dto.setName(productCategoryDto.getName());
                    return dto;
                });
    }

    @Override
    public Collection<ProductCategoryDto> findAllProductCategoryCollections() {
        Collection<ProductCategory> productCategories = findAll();
        Collection<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        productCategories.forEach(productCategory ->
                productCategoryDtos.add(productCategoryMapper.productCategoryDtoFromProductCategory(productCategory)));
        return productCategoryDtos;
    }

    @Override
    public Page<ProductCategory> findAll(java.awt.print.Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    public ProductCategory create(ProductCategoryRequest createDto) {
        Optional<ProductCategory> optionalProductCategory = productCategoryDao.findByNameIgnoreCase(createDto.getName());
        if (optionalProductCategory.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        ProductCategory productCategory = productCategoryMapper
                .productCategoryFromProductCategoryRequest(createDto);
        return productCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategoryUpdateRequest updateDto) {
        ProductCategory productCategoryRecord = findById(updateDto.getId());
        ProductCategory productCategory = productCategoryMapper
                .productCategoryFromProductCategoryUpdateRequest(productCategoryRecord, updateDto);
        return productCategoryDao.save(productCategory);
    }

    @Override
    protected Class<ProductCategory> getEntityClass() {
        return ProductCategory.class;
    }
}
