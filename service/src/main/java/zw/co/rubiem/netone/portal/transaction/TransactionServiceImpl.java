package zw.co.rubiem.netone.portal.transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private static final String PAYMENT_NUMBER_PREFIX = "PAY";
    private final TransactionDao transactionDao;
    private final TransactionMapper transactionMapper;

    @Override
    public InitiatePaymentResponse create(TransactionRequest request) {
        Transaction transaction = transactionMapper.transactionFromTransactionRequest(request);
        Transaction savedTransaction = transactionDao.save(transaction);
        return transactionMapper.initiatePaymentResponseFromTransaction(savedTransaction);
    }

    @Override
    public void updateStatus(String paymentNumber, PaymentStatusEnum status) {
        Transaction transaction = findByPaymentNumber(paymentNumber);
        transaction.setStatus(status);
        transactionDao.save(transaction);
    }

    @Override
    public PaymentResponse checkStatus(String paymentNumber) {
        Transaction transaction = findByPaymentNumber(paymentNumber);
        return transactionMapper.paymentResponseFromTransaction(transaction);
    }

    @Override
    public List<Transaction> findTransactionsDueToBeCheckedOnPayNow(Integer chunkSize) {
        //return transactionDao.findTransactionsDueToBeCheckedOnPayNow(PaymentStatusEnum.PENDING.name(), chunkSize);
        return transactionDao.findByStatus(PaymentStatusEnum.PENDING);
    }

    @Override
    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    private Transaction findByPaymentNumber(String paymentNumber) {
        return transactionDao.findByPaymentNumber(paymentNumber)
                .orElseThrow(() -> new ItemNotFoundException("Transaction"));
    }

}
