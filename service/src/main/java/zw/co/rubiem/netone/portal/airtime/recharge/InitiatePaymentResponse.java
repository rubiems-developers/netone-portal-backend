package zw.co.rubiem.netone.portal.airtime.recharge;

import lombok.Data;

@Data
public class InitiatePaymentResponse {
    PaynowMobileInitResponse response;
    private InitiatePaymentStatusEnum result;
}

