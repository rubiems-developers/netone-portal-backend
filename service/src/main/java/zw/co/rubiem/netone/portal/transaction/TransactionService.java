package zw.co.rubiem.netone.portal.transaction;

import java.util.List;

public interface TransactionService {

    InitiatePaymentResponseDepr create(TransactionRequest request);

    void updateStatus(String paymentNumber, PaymentStatusEnum status);

    PaymentResponse checkStatus(String paymentNumber);

    List<Transaction> findTransactionsDueToBeCheckedOnPayNow(Integer chunkSize);

    void save(Transaction transaction);
}
