package zw.co.rubiem.netone.portal.service.airtime.recharge;

import lombok.Data;

@Data
public class AirtimeRechargeDto {
    private Long id;
    private String recipientNumber;
    private double rechargeAmount;
    private String payerNumber;
    private String paymentMethod;
}
