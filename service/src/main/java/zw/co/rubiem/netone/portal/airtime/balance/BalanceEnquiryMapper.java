package zw.co.rubiem.netone.portal.airtime.balance;
import zw.co.rubiem.netone.portal.airtime.BalanceEnquiry;


public interface BalanceEnquiryMapper {
    BalanceEnquiryDto balanceEnquiryDtoFromBalanceEnquiry (BalanceEnquiry balanceEnquiry);

    BalanceEnquiry balanceEnquiryFromBalanceEnquiryRequest(BalanceEnquiryRequest balanceEnquiryRequest);

    BalanceEnquiry balanceEnquiryFromBalanceEnquiryUpdateRequest(BalanceEnquiry balanceEnquiryRecord,BalanceEnquiryUpdateRequest balanceEnquiryUpdateRequest);

}
