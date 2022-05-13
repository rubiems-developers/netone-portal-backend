package zw.co.rubiem.netone.portal.service.airtime.balance;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.commons.demographics.PhoneNumber;

@Data
public class BalanceEnquiryDto {
    private Long id;
    private String phoneNumber;
    private String reference;

}
