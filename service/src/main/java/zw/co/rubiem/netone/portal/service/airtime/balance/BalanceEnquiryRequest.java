package zw.co.rubiem.netone.portal.service.airtime.balance;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.commons.demographics.PhoneNumber;
import javax.validation.constraints.NotBlank;

@Data
public class BalanceEnquiryRequest {
    @NotBlank(message = "Phone Number is required!")
    private String targetMobile;
    private String reference;

}
