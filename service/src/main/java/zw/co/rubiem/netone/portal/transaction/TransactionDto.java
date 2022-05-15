package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;
import zw.co.rubiem.netone.portal.transaction.PaymentStatusEnum;

@Data
public class TransactionDto {
    private Long id;
    private String paymentNumber;
    private String paymentAccount;
    private PaymentStatusEnum status;
    private String paynowReference;
}
