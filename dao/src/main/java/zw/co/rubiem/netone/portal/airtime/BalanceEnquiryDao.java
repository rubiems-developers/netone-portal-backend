package zw.co.rubiem.netone.portal.airtime;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;
@Repository
public interface BalanceEnquiryDao extends BaseDao<BalanceEnquiry> {
    Optional<BalanceEnquiry> findByReferenceIgnoreCase(String reference);
}
