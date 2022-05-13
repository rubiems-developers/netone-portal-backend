package zw.co.rubiem.netone.portal.service.transaction;

import zw.co.rubiem.netone.portal.domain.transaction.Transaction;

public interface TransactionMapper {
    Transaction transactionFromTransactionRequest(TransactionRequest transactionRequest);
    TransactionDto transactionDtoFromTransaction(Transaction transaction);
    PaymentResponse paymentResponseFromTransaction(Transaction transaction);
    InitiatePaymentResponse initiatePaymentResponseFromTransaction(Transaction transaction);
}
