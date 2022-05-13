package zw.co.rubiem.netone.portal.service.airtime.recharge;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AirtimeRechargeRequest {
    @NotBlank(message = "RecipientNumber is required!")
    private String recipientNumber;

    @NotBlank(message = "RechargeAmount is required!")
    private double rechargeAmount;

    @NotBlank(message = "PayerNumber is required!")
    private String payerNumber;


    @NotBlank(message = "paymentMethod is required!")
    private String paymentMethod;
}
