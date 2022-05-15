package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;

@Data
public class PaymentResponse {
    private String paymentAccount;
    private String paymentNumber;
    private String paynowReference;
    private PaymentStatusEnum status;
}

