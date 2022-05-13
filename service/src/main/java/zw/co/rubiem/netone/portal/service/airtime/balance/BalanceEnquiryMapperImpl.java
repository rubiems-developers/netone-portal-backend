package zw.co.rubiem.netone.portal.service.airtime.balance;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.airtime.BalanceEnquiry;


import java.util.Objects;

@Component
public class BalanceEnquiryMapperImpl implements BalanceEnquiryMapper {
    @Override
    public BalanceEnquiryDto balanceEnquiryDtoFromBalanceEnquiry(BalanceEnquiry balanceEnquiry) {
        Objects.requireNonNull(balanceEnquiry, "BalanceEnquiry must not be null");
        BalanceEnquiryDto balanceEnquiryDto = new BalanceEnquiryDto();
        balanceEnquiryDto.setId(balanceEnquiry.getId());
        balanceEnquiryDto.setPhoneNumber(balanceEnquiry.getPhoneNumber());
        balanceEnquiryDto.setReference(balanceEnquiry.getReference());
        return balanceEnquiryDto;
    }

    @Override
    public BalanceEnquiry balanceEnquiryFromBalanceEnquiryRequest(BalanceEnquiryRequest balanceEnquiryRequest) {
        Objects.requireNonNull(balanceEnquiryRequest, "BranchRequest must not be null");
        BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
        balanceEnquiry.setPhoneNumber(balanceEnquiryRequest.getTargetMobile());
        return balanceEnquiry;
    }

    @Override
    public BalanceEnquiry balanceEnquiryFromBalanceEnquiryUpdateRequest(BalanceEnquiry balanceEnquiryRecord, BalanceEnquiryUpdateRequest balanceEnquiryUpdateRequest) {
        return null;
    }
}
