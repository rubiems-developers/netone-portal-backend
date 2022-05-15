package zw.co.rubiem.netone.portal.api.airtime;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.rubiem.netone.portal.commons.demographics.PhoneNumber;
import zw.co.rubiem.netone.portal.airtime.balance.BalanceEnquiryMapper;
import zw.co.rubiem.netone.portal.airtime.balance.BalanceEnquiryRequest;
import zw.co.rubiem.netone.portal.airtime.balance.BalanceEnquiryService;

import java.util.UUID;


@CrossOrigin
@RestController
@Api(tags = "Balance Enquiry")
@RequestMapping("v1/balance_enquiry")
public class BalanceEnquiryController {
    private final BalanceEnquiryService balanceEnquiryService;
    private final BalanceEnquiryMapper balanceEnquiryMapper;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final JSONParser parser = new JSONParser();

    public BalanceEnquiryController(BalanceEnquiryService balanceEnquiryService, BalanceEnquiryMapper balanceEnquiryMapper) {
        this.balanceEnquiryService = balanceEnquiryService;
        this.balanceEnquiryMapper = balanceEnquiryMapper;
    }

    @GetMapping
    @ApiOperation("Create a Balance Enquiry")
    public String sendGet(BalanceEnquiryRequest request1) throws Exception {
        PhoneNumber.of(request1.getTargetMobile());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HttpGet request = new HttpGet("https://pinlessevd.netone.co.zw/api/v1/agents/enduser-balance?targetMobile=" + request1.getTargetMobile());
        // add request headers
        request.addHeader("x-agent-reference", uuid);
        request.setHeader("Accept", "application/json");
        request.addHeader("x-access-code", "dennis@rubiem.com");
        request.addHeader("x-access-password", "@Cancel@123@");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            JSONObject json = (JSONObject) parser.parse(result);
            if (response.getStatusLine().getStatusCode() == 200) {
                // System.out.println( json.get("ReplyCode"));
                balanceEnquiryMapper.balanceEnquiryDtoFromBalanceEnquiry(balanceEnquiryService.create(request1));
            }
            return result;
        }
    }

}
