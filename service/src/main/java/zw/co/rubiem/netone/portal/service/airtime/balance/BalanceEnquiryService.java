package zw.co.rubiem.netone.portal.service.airtime.balance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.airtime.BalanceEnquiry;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;

import java.util.Collection;

public interface BalanceEnquiryService extends BaseService<BalanceEnquiry, BalanceEnquiryRequest, BalanceEnquiryUpdateRequest> {
    BalanceEnquiryDto findBalanceEnquiryById(Long id);
    Page<BalanceEnquiryDto> findAllBalanceEnquiries(Pageable pageable, String searchQuery);

    Collection<BalanceEnquiryDto> findAllBalanceEnquiries();

}
