package zw.co.rubiem.netone.portal.dao.airtime;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.airtime.BalanceEnquiry;
import zw.co.rubiem.netone.portal.domain.commons.demographics.PhoneNumber;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;

import java.util.Optional;
@Repository
public interface BalanceEnquiryDao extends BaseDao<BalanceEnquiry> {
    Optional<BalanceEnquiry> findByReferenceIgnoreCase(String reference);
}
