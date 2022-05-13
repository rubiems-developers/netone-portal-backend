package zw.co.rubiem.netone.portal.service.transaction;

import zw.co.rubiem.netone.portal.domain.transaction.PaymentStatusEnum;
import zw.co.rubiem.netone.portal.domain.transaction.Transaction;

import java.util.List;

public interface TransactionService {

    InitiatePaymentResponse create(TransactionRequest request);

    void updateStatus(String paymentNumber, PaymentStatusEnum status);

    PaymentResponse checkStatus(String paymentNumber);

    public List<Transaction> findTransactionsDueToBeCheckedOnPayNow(Integer chunkSize);

    void save(Transaction transaction);
}
