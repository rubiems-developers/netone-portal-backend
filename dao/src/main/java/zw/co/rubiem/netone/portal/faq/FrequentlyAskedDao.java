package zw.co.rubiem.netone.portal.faq;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface FrequentlyAskedDao extends BaseDao<FrequentlyAsked> {
    Optional<FrequentlyAsked> findByQuestionIgnoreCase(String question);
}
