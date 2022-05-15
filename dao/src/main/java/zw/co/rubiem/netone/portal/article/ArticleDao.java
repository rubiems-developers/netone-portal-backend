package zw.co.rubiem.netone.portal.dao.article;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.article.Article;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface ArticleDao extends BaseDao<Article> {
    Optional<Article> findByTitleIgnoreCase(String title);

}
