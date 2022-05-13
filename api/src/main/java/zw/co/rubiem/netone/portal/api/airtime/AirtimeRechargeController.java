package zw.co.rubiem.netone.portal.api.airtime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.paynow.constants.MobileMoneyMethod;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.MobileInitResponse;
import zw.co.paynow.responses.StatusResponse;
import zw.co.rubiem.netone.portal.domain.transaction.Transaction;
import zw.co.rubiem.netone.portal.service.airtime.recharge.AirtimeRechargeRequest;
import zw.co.rubiem.netone.portal.service.transaction.InitiatePaymentResponse;
import zw.co.rubiem.netone.portal.service.transaction.PaymentResponse;
import zw.co.rubiem.netone.portal.service.transaction.TransactionRequest;
import zw.co.rubiem.netone.portal.service.transaction.TransactionService;

import java.util.UUID;

@CrossOrigin
@RestController
@Api(tags = "Airtime Recharge")
@RequestMapping("v1/airtime_recharge")
public class AirtimeRechargeController {

    private final TransactionService transactionService;

    public AirtimeRechargeController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("")
    @ApiOperation("Recharge Airtime ")
    public InitiatePaymentResponse airtimePurchase(@RequestBody AirtimeRechargeRequest airtimeRechargeRequest) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Paynow paynow = new Paynow("12616", "da314f42-fdf6-4bf9-a60a-49d9b4800740");
        Payment payment = paynow.createPayment(uuid, "warrenszingwena@gmail.com");
        payment.add("Airtime Purchase", airtimeRechargeRequest.getRechargeAmount());
        MobileInitResponse response = paynow.sendMobile(payment, airtimeRechargeRequest.getPayerNumber(),
                MobileMoneyMethod.valueOf(airtimeRechargeRequest.getPaymentMethod()));
        TransactionRequest transactionRequest = TransactionRequest.of(response, airtimeRechargeRequest);
        return transactionService.create(transactionRequest);
    }

    @GetMapping("/check-status")
    public PaymentResponse checkStatus(@RequestParam String orderNumber) {
        return transactionService.checkStatus(orderNumber);
    }

}
