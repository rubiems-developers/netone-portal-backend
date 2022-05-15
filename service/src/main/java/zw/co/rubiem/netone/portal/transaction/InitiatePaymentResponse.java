package com.paynow.paynowdemo.initiatepayment.context;

import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 2/18/2021
 * @project zimbostoro-be-adapter
 */

@Data
public class InitiatePaymentResponse {

    private String paynowReference;
    private String pollUrl;
    private String result;

}

