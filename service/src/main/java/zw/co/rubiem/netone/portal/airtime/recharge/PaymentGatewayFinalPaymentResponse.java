package zw.co.rubiem.netone.portal.airtime.recharge;

import lombok.Data;

@Data
public class PaymentGatewayFinalPaymentResponse {
    private String merchantReference;
    private String paynowReference;
    private String result;
    private TransactionStatus transactionStatus;

}

@Data
class TransactionStatus {

    private String name;
    private String description;
    private String responseString;

}