package zw.co.rubiem.netone.portal.service.transaction;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.transaction.PaymentStatusEnum;

@Data
public class TransactionDto {
    private Long id;
    private String paymentNumber;
    private String paymentAccount;
    private PaymentStatusEnum status;
    private String paynowReference;
}
