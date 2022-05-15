package zw.co.rubiem.netone.portal.transaction;

import lombok.Data;

@Data
public class InitiatePaymentResponse {

    private String paynowReference;
    private String pollUrl;
    private String result;
    private String message;

}

