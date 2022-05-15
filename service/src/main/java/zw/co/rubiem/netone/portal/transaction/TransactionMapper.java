package zw.co.rubiem.netone.portal.transaction;

public interface TransactionMapper {
    Transaction transactionFromTransactionRequest(TransactionRequest transactionRequest);
    TransactionDto transactionDtoFromTransaction(Transaction transaction);
    PaymentResponse paymentResponseFromTransaction(Transaction transaction);
    InitiatePaymentResponse initiatePaymentResponseFromTransaction(Transaction transaction);
}
