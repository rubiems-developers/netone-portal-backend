package zw.co.rubiem.netone.portal.dao.faq;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.domain.faq.FrequentlyAsked;
import java.util.Optional;

@Repository
public interface FrequentlyAskedDao extends BaseDao<FrequentlyAsked> {
    Optional<FrequentlyAsked> findByQuestionIgnoreCase(String question);
}
