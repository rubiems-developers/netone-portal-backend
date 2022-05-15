package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;
import zw.co.rubiem.netone.portal.transaction.PaymentStatusEnum;

@Data
public class PaymentResponse {
    private String paymentAccount;
    private String paymentNumber;
    private String paynowReference;
    private PaymentStatusEnum status;
}

