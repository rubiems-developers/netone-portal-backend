package zw.co.rubiem.netone.portal.service.transaction;

import lombok.Data;

@Data
public class InitiatePaymentResponse {

    private String paymentAccount;
    private double amount;
    private String paymentNumber;

}

