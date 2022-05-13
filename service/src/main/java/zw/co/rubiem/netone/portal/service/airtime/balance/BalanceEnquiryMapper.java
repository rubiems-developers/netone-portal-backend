package zw.co.rubiem.netone.portal.service.airtime.balance;
import zw.co.rubiem.netone.portal.domain.airtime.BalanceEnquiry;


public interface BalanceEnquiryMapper {
    BalanceEnquiryDto balanceEnquiryDtoFromBalanceEnquiry (BalanceEnquiry balanceEnquiry);

    BalanceEnquiry balanceEnquiryFromBalanceEnquiryRequest(BalanceEnquiryRequest balanceEnquiryRequest);

    BalanceEnquiry balanceEnquiryFromBalanceEnquiryUpdateRequest(BalanceEnquiry balanceEnquiryRecord,BalanceEnquiryUpdateRequest balanceEnquiryUpdateRequest);

}
