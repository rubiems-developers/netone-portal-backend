package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;
import zw.co.paynow.responses.MobileInitResponse;
import zw.co.rubiem.netone.portal.airtime.recharge.AirtimeRechargeRequest;

import java.util.Objects;

@Data
public class TransactionRequest {

    private String paymentAccount;
    private PaymentStatusEnum status;
    private String paynowReference;
    private String paynowPollUrl;
    private double rechargeAmount;
    private String airtimeRecipientNumber;

    public static TransactionRequest of(MobileInitResponse response, AirtimeRechargeRequest airtimeRechargeRequest) {
        Objects.requireNonNull(response, "Paynow response cannot be null");
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setPaymentAccount(airtimeRechargeRequest.getPayerNumber());
        transactionRequest.setPaynowReference(response.getPaynowReference());
        transactionRequest.setPaynowPollUrl(response.getPollUrl());
        transactionRequest.setStatus(PaymentStatusEnum.PENDING);
        transactionRequest.setAirtimeRecipientNumber(transactionRequest.airtimeRecipientNumber);
        transactionRequest.setRechargeAmount(airtimeRechargeRequest.getRechargeAmount());
        return transactionRequest;
    }
}
