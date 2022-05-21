package zw.co.rubiem.netone.portal.airtime.recharge;

import lombok.Data;

@Data
public class PaynowMobileInitResponse {
    private String pollUrl;
    private String paynowReference;
    private String instructions;
}
