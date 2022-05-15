package zw.co.rubiem.netone.portal.dao.faq;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.faq.FrequentlyAsked;

import java.util.Optional;

@Repository
public interface FrequentlyAskedDao extends BaseDao<FrequentlyAsked> {
    Optional<FrequentlyAsked> findByQuestionIgnoreCase(String question);
}
