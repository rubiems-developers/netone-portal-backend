package zw.co.rubiem.netone.portal.service.airtime.balance;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.commons.demographics.PhoneNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class BalanceEnquiryUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;

    @NotBlank(message = "Phone Number is required!")
    private String phoneNumber;
}
