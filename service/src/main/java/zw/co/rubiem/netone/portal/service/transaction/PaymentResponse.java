package zw.co.rubiem.netone.portal.service.transaction;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.transaction.PaymentStatusEnum;

@Data
public class PaymentResponse {
    private String paymentAccount;
    private String paymentNumber;
    private String paynowReference;
    private PaymentStatusEnum status;
}

