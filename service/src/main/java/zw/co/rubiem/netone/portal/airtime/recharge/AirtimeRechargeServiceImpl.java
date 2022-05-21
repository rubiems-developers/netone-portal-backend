package zw.co.rubiem.netone.portal.airtime.recharge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zw.co.rubiem.netone.portal.transaction.InitiatePaymentResponseDepr;
import zw.co.rubiem.netone.portal.transaction.TransactionRequest;
import zw.co.rubiem.netone.portal.transaction.TransactionService;


@Service
public class AirtimeRechargeServiceImpl implements AirtimeRechargeService {

    private final Logger logger = LoggerFactory.getLogger(AirtimeRechargeServiceImpl.class);
    private final RestTemplate restTemplate;
    private final TransactionService transactionService;

    public AirtimeRechargeServiceImpl(RestTemplate restTemplate, TransactionService transactionService) {
        this.restTemplate = restTemplate;
        this.transactionService = transactionService;
    }

    @Override
    public InitiatePaymentResponseDepr purchaseAirtime(AirtimeRechargeRequest airtimeRechargeRequest) {
        InitiatePaymentResponse initiatePaymentResponse = initiatePaymentStub(airtimeRechargeRequest.getRechargeAmount(), airtimeRechargeRequest.getPayerNumber());
        TransactionRequest transactionRequest = TransactionRequest.of(initiatePaymentResponse.getResponse(), airtimeRechargeRequest);
        return transactionService.create(transactionRequest);
    }

    public InitiatePaymentResponse initiatePaymentStub(double amount, String paymentAccount) {
        final String uri = "http://localhost:8081/paynow/initiate-mobile-money-payment?amount="
                + amount + "&paymentAccount=" + paymentAccount;
        InitiatePaymentResponse result = restTemplate.getForObject(uri, InitiatePaymentResponse.class);
        logger.info("PaymentGatewayResponse {} " + result);
        logger.info("done");
        return result;
    }

    public PaymentGatewayFinalPaymentResponse checkPaymentStatusStub(CheckPaymentStatusRequest checkPaymentStatusRequest) {
        final String uri = "http://localhost:8081/paynow/check-payment-status";
        PaymentGatewayFinalPaymentResponse result = restTemplate.postForObject(uri, checkPaymentStatusRequest, PaymentGatewayFinalPaymentResponse.class);
        logger.info("PaymentGatewayFinalPaymentResponse {} " + result);
        return result;
    }

}
