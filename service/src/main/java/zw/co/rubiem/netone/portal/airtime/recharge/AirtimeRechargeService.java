package zw.co.rubiem.netone.portal.airtime.recharge;

import zw.co.rubiem.netone.portal.transaction.InitiatePaymentResponseDepr;

public interface AirtimeRechargeService {
    InitiatePaymentResponseDepr purchaseAirtime(AirtimeRechargeRequest airtimeRechargeRequest);
    PaymentGatewayFinalPaymentResponse checkPaymentStatusStub(CheckPaymentStatusRequest checkPaymentStatusRequest);
}
