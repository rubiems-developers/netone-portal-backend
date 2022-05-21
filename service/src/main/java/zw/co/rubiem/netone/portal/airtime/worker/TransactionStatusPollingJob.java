package zw.co.rubiem.netone.portal.airtime.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeService;
import zw.co.rubiem.netone.portal.airtime.recharge.CheckPaymentStatusRequest;
import zw.co.rubiem.netone.portal.airtime.recharge.PaymentGatewayFinalPaymentResponse;
import zw.co.rubiem.netone.portal.transaction.PaymentStatusEnum;
import zw.co.rubiem.netone.portal.transaction.Transaction;
import zw.co.rubiem.netone.portal.transaction.TransactionService;

import java.util.List;

@Component
@Profile("job")
public class TransactionStatusPollingJob {

    private static final int CHUNK_SIZE = 10;
    private final Logger logger = LoggerFactory.getLogger(TransactionStatusPollingJob.class);
    private final TransactionService transactionService;
    private final PerformRecharge performRecharge;
    private final AirtimeRechargeService airtimeRechargeService;

    public TransactionStatusPollingJob(TransactionService transactionService, PerformRecharge performRecharge, AirtimeRechargeService airtimeRechargeService) {
        this.transactionService = transactionService;
        this.performRecharge = performRecharge;
        this.airtimeRechargeService = airtimeRechargeService;
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
        CheckPaymentStatusRequest checkPaymentStatusRequest = new CheckPaymentStatusRequest();
        checkPaymentStatusRequest.setPaynowReference(transaction.getPaynowReference());
        checkPaymentStatusRequest.setPollUrl(transaction.getPaynowPollUrl());
        PaymentGatewayFinalPaymentResponse gatewayFinalPaymentResponse = airtimeRechargeService.checkPaymentStatusStub(checkPaymentStatusRequest);
        boolean paid = gatewayFinalPaymentResponse.getResult().equalsIgnoreCase("success");
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
