package zw.co.rubiem.netone.portal.service.transaction;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.transaction.Transaction;

import java.util.Objects;

@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction transactionFromTransactionRequest(TransactionRequest transactionRequest) {
        Objects.requireNonNull(transactionRequest, "TransactionRequest must not be null");
        Transaction transaction = new Transaction();
        transaction.setPaymentAccount(transactionRequest.getPaymentAccount());
        transaction.setAirtimeRecipientNumber(transactionRequest.getAirtimeRecipientNumber());
        transaction.setRechargeAmount(transactionRequest.getRechargeAmount());
        transaction.setPaymentNumber(transactionRequest.getPaynowReference());
        transaction.setPaynowReference(transactionRequest.getPaynowReference());
        transaction.setPaynowPollUrl(transactionRequest.getPaynowPollUrl());
        transaction.setStatus(transactionRequest.getStatus());
        return transaction;
    }

    @Override
    public TransactionDto transactionDtoFromTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction, "Transaction must not be null");
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setPaymentAccount(transaction.getPaymentAccount());
        transactionDto.setPaymentNumber(transaction.getPaymentNumber());
        transactionDto.setPaynowReference(transaction.getPaynowReference());
        transactionDto.setStatus(transaction.getStatus());
        return transactionDto;
    }

    @Override
    public PaymentResponse paymentResponseFromTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction, "Transaction must not be null");
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentAccount(transaction.getPaymentAccount());
        paymentResponse.setPaymentNumber(transaction.getPaymentNumber());
        paymentResponse.setPaynowReference(transaction.getPaynowReference());
        paymentResponse.setStatus(transaction.getStatus());
        return paymentResponse;
    }

    @Override
    public InitiatePaymentResponse initiatePaymentResponseFromTransaction(Transaction transaction) {
        Objects.requireNonNull(transaction, "Transaction must not be null");
        InitiatePaymentResponse initiatePaymentResponse = new InitiatePaymentResponse();
        initiatePaymentResponse.setPaymentAccount(transaction.getPaymentAccount());
        initiatePaymentResponse.setAmount(transaction.getRechargeAmount());
        initiatePaymentResponse.setPaymentNumber(transaction.getPaymentNumber());
        return initiatePaymentResponse;
    }

}
