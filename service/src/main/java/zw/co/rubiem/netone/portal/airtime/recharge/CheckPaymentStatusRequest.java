package zw.co.rubiem.netone.portal.airtime.recharge;

import lombok.Data;

@Data
public class CheckPaymentStatusRequest {
    private String paynowReference;
    private String pollUrl;
}
