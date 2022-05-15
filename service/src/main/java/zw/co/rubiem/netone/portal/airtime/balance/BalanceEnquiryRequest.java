package zw.co.rubiem.netone.portal.airtime.balance;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BalanceEnquiryRequest {
    @NotBlank(message = "Phone Number is required!")
    private String targetMobile;
    private String reference;

}
