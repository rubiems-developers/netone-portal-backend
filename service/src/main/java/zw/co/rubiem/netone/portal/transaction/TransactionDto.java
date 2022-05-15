package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;

@Data
public class TransactionDto {
    private Long id;
    private String paymentNumber;
    private String paymentAccount;
    private PaymentStatusEnum status;
    private String paynowReference;
}
