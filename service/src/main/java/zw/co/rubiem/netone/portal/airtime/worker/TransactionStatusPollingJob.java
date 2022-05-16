package zw.co.rubiem.netone.portal.airtime.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.StatusResponse;
import zw.co.rubiem.netone.portal.transaction.PaymentStatusEnum;
import zw.co.rubiem.netone.portal.transaction.Transaction;
import zw.co.rubiem.netone.portal.transaction.TransactionService;

import java.util.List;
import java.util.Random;

@Component
//@Profile("job")
public class TransactionStatusPollingJob {

    private static final int CHUNK_SIZE = 10;
    private final Logger logger = LoggerFactory.getLogger(TransactionStatusPollingJob.class);
    private final TransactionService transactionService;
    private final PerformRecharge performRecharge;

    public TransactionStatusPollingJob(TransactionService transactionService, PerformRecharge performRecharge) {
        this.transactionService = transactionService;
        this.performRecharge = performRecharge;
    }

    @Scheduled(fixedRate = 30000)
    public void readToPoll() {
        logger.info("### Doing the TransactionStatusPollingJob");
        List<Transaction> transactionList = transactionService.findTransactionsDueToBeCheckedOnPayNow(CHUNK_SIZE);
        logger.info("### Total elements found : {}, The elements {}", transactionList.size(), transactionList);
        transactionList.stream().parallel().forEach(transaction -> {
            if (transaction.getStatus().equals(PaymentStatusEnum.PENDING)) {
                pollFromPaynow(transaction);
            }
        });
    }

    private void pollFromPaynow(Transaction transaction) {
        //TODO manage --- apply singleton
        Paynow paynow = new Paynow("12616", "da314f42-fdf6-4bf9-a60a-49d9b4800740");
        String pollUrl = transaction.getPaynowPollUrl();
        boolean paid;

        try {
            StatusResponse status = paynow.pollTransaction(pollUrl);
            paid = status.paid();
        } catch (Exception e) {
            paid = new Random().nextBoolean();
        }
        getResponse(transaction, paid);
    }

    private void getResponse(Transaction transaction, boolean paid) {
        if (paid) {
            logger.info("### Yay! Transaction was paid for");
            performRecharge.perform(transaction);
            transaction.setStatus(PaymentStatusEnum.SUCCESS);
            transactionService.save(transaction);
        } else {
            logger.info("### Cancelled");
            transaction.setStatus(PaymentStatusEnum.FAILED);
            transactionService.save(transaction);
        }
    }

}
