package zw.co.rubiem.netone.portal.airtime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeRequest;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeService;
import zw.co.rubiem.netone.portal.transaction.InitiatePaymentResponseDepr;
import zw.co.rubiem.netone.portal.transaction.PaymentResponse;
import zw.co.rubiem.netone.portal.transaction.TransactionService;

@CrossOrigin
@RestController
@Api(tags = "Airtime Recharge")
@RequestMapping("")
public class AirtimeRechargeController {

    private final Logger logger = LoggerFactory.getLogger(AirtimeRechargeController.class);
    private final AirtimeRechargeService airtimeRechargeService;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final JSONParser parser = new JSONParser();
    private final TransactionService transactionService;

    public AirtimeRechargeController(AirtimeRechargeService airtimeRechargeService, TransactionService transactionService) {
        this.airtimeRechargeService = airtimeRechargeService;
        this.transactionService = transactionService;
    }

    @RequestMapping("v1/airtime_recharge")
    @ApiOperation("Recharge Airtime ")
    public InitiatePaymentResponseDepr airtimePurchase(@RequestBody AirtimeRechargeRequest airtimeRechargeRequest) {
        return airtimeRechargeService.purchaseAirtime(airtimeRechargeRequest);
    }

    @GetMapping("v1/airtime_recharge/check-status")
    public PaymentResponse checkStatus(@RequestParam String orderNumber) {
        return transactionService.checkStatus(orderNumber);
    }

}
