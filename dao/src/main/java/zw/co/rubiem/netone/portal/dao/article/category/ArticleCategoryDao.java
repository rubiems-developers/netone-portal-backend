package zw.co.rubiem.netone.portal.dao.article.category;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.article.category.ArticleCategory;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface ArticleCategoryDao extends BaseDao<ArticleCategory> {
    Optional<ArticleCategory> findByNameIgnoreCase(String name);
}
