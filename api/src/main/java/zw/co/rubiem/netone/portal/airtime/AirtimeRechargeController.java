package zw.co.rubiem.netone.portal.airtime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import zw.co.paynow.constants.MobileMoneyMethod;
import zw.co.paynow.core.Payment;
import zw.co.paynow.core.Paynow;
import zw.co.paynow.responses.MobileInitResponse;
import zw.co.paynow.responses.StatusResponse;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeMapper;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeRequest;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeService;
import zw.co.rubiem.netone.portal.transaction.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@Api(tags = "Airtime Recharge")
@RequestMapping("")
public class AirtimeRechargeController {

    private final Logger logger = LoggerFactory.getLogger(AirtimeRechargeController.class);
    private final AirtimeRechargeService airtimeRechargeService;
    private final AirtimeRechargeMapper airtimeRechargeMapper;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final JSONParser parser = new JSONParser();
    private final TransactionService transactionService;

    public AirtimeRechargeController(AirtimeRechargeService airtimeRechargeService, AirtimeRechargeMapper airtimeRechargeMapper, TransactionService transactionService) {
        this.airtimeRechargeService = airtimeRechargeService;
        this.airtimeRechargeMapper = airtimeRechargeMapper;
        this.transactionService = transactionService;
    }


    @PostMapping("v2/airtime_recharge")
    @ApiOperation("Recharge Airtime V2")
    public InitiatePaymentResponse airtimePurchaseV2(@RequestBody AirtimeRechargeRequest airtimeRechargeRequest) throws IOException, ParseException {
        CloseableHttpClient client = HttpClients.createDefault();

        String uuid = UUID.randomUUID().toString().replace("-", "");
        Paynow paynow = new Paynow("12616", "da314f42-fdf6-4bf9-a60a-49d9b4800740");
        Payment payment = paynow.createPayment(uuid, "warrenszingwena@gmail.com");
        payment.add("Airtime Purchase", airtimeRechargeRequest.getRechargeAmount());
        MobileInitResponse response = paynow.sendMobile(payment, airtimeRechargeRequest.getPayerNumber(), MobileMoneyMethod.valueOf(airtimeRechargeRequest.getPaymentMethod()));
        InitiatePaymentResponse initiatePaymentResponse = getInitiatePaymentResponse(response);
        if (response.isRequestSuccess()) {
            try {
                Thread.sleep(30000);
            } catch (Exception e) {
            }
            String pollUrl = response.pollUrl();
            StatusResponse status = paynow.pollTransaction(pollUrl);
            if (status.paid()) {
                initiatePaymentResponse.setResult("Success");
                HttpPost httpPost = new HttpPost("https://pinlessevd.netone.co.zw/api/v1/agents/recharge-pinless");
                httpPost.addHeader("x-agent-reference", uuid);
                httpPost.setHeader("Accept", "application/json");
                httpPost.addHeader("x-access-code", "dennis@rubiem.com");
                httpPost.addHeader("x-access-password", "@Cancel@123@");
                httpPost.addHeader("CustomerSMS", "Thank you for using the platform");

                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("targetMobile", airtimeRechargeRequest.getRecipientNumber()));
                params.add(new BasicNameValuePair("amount", String.valueOf(airtimeRechargeRequest.getRechargeAmount())));
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                try (CloseableHttpResponse response2 = client.execute(httpPost)) {
                    HttpEntity entity = response2.getEntity();
                    String result = EntityUtils.toString(entity);
                    JSONObject json = (JSONObject) parser.parse(result);
                    String output;
                    if ((response2.getStatusLine().getStatusCode() == 200)) {
                        output = (String) json.get("ReplyMsg");
                        airtimeRechargeMapper.airtimeRechargeDtoFromAirtimeRecharge(airtimeRechargeService.create(airtimeRechargeRequest));
                    } else {
                        output = (String) json.get("ReplyMessage");
                    }
                    initiatePaymentResponse.setMessage(output);
                    return initiatePaymentResponse;
                }
            } else {
                initiatePaymentResponse.setResult("Cancelled");
            }
        }
        initiatePaymentResponse.setMessage("Your transaction was not successful.");
        return initiatePaymentResponse;
    }

    @RequestMapping("v1/airtime_recharge")
    @ApiOperation("Recharge Airtime ")
    public InitiatePaymentResponseDepr airtimePurchase(@RequestBody AirtimeRechargeRequest airtimeRechargeRequest) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Paynow paynow = new Paynow("12616", "da314f42-fdf6-4bf9-a60a-49d9b4800740");
        Payment payment = paynow.createPayment(uuid, "warrenszingwena@gmail.com");
        payment.add("Airtime Purchase", airtimeRechargeRequest.getRechargeAmount());
        MobileInitResponse response = paynow.sendMobile(payment, airtimeRechargeRequest.getPayerNumber(),
                MobileMoneyMethod.valueOf(airtimeRechargeRequest.getPaymentMethod()));
        TransactionRequest transactionRequest = TransactionRequest.of(response, airtimeRechargeRequest);
        return transactionService.create(transactionRequest);
    }

    @GetMapping("v1/airtime_recharge/check-status")
    public PaymentResponse checkStatus(@RequestParam String orderNumber) {
        return transactionService.checkStatus(orderNumber);
    }


    InitiatePaymentResponse getInitiatePaymentResponse(MobileInitResponse mobileInitResponse) {
        InitiatePaymentResponse initiatePaymentResponse = new InitiatePaymentResponse();

        if (mobileInitResponse.isRequestSuccess()) {
            logger.info("### initiating a transaction was successful");
            initiatePaymentResponse.setPaynowReference(mobileInitResponse.getPaynowReference());
            initiatePaymentResponse.setPollUrl(mobileInitResponse.getPollUrl());

        } else {
            logger.info("### Failed to initiate a transaction!!!");
            logger.info("### errors occurred {}" + mobileInitResponse.errors());
            initiatePaymentResponse.setResult(mobileInitResponse.errors());
            initiatePaymentResponse.setPaynowReference(mobileInitResponse.getPaynowReference());
        }

        return initiatePaymentResponse;

    }

}
