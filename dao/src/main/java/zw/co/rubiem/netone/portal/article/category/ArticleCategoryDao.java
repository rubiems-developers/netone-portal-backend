package zw.co.rubiem.netone.portal.article.category;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface ArticleCategoryDao extends BaseDao<ArticleCategory> {
    Optional<ArticleCategory> findByNameIgnoreCase(String name);
}
