package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;

@Data
public class InitiatePaymentResponseDepr {

    private String paymentAccount;
    private double amount;
    private String paymentNumber;

}

