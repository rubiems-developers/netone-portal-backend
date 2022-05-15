package zw.co.rubiem.netone.portal.transaction;

import java.util.List;

public interface TransactionService {

    InitiatePaymentResponse create(TransactionRequest request);

    void updateStatus(String paymentNumber, PaymentStatusEnum status);

    PaymentResponse checkStatus(String paymentNumber);

    public List<Transaction> findTransactionsDueToBeCheckedOnPayNow(Integer chunkSize);

    void save(Transaction transaction);
}
