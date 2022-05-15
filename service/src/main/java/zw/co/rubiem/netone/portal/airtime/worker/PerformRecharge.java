package zw.co.rubiem.netone.portal.airtime.worker;

import lombok.SneakyThrows;
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
import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PerformRecharge {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final JSONParser parser = new JSONParser();

    @SneakyThrows
    public String perform(Transaction transaction) {
        CloseableHttpClient client = HttpClients.createDefault();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HttpPost httpPost = new HttpPost("https://pinlessevd.netone.co.zw/api/v1/agents/recharge-pinless");
        httpPost.addHeader("x-agent-reference", uuid);
        httpPost.setHeader("Accept", "application/json");
        httpPost.addHeader("x-access-code", "dennis@rubiem.com");
        httpPost.addHeader("x-access-password", "@Cancel@123@");
        httpPost.addHeader("CustomerSMS", "Thank you for using the platform");

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("targetMobile", transaction.getAirtimeRecipientNumber()));
        params.add(new BasicNameValuePair("amount", String.valueOf(transaction.getRechargeAmount())));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        try (CloseableHttpResponse response2 = client.execute(httpPost)) {
            HttpEntity entity = response2.getEntity();
            String result = EntityUtils.toString(entity);
            JSONObject json = (JSONObject) parser.parse(result);
            String output;
            if ((response2.getStatusLine().getStatusCode() == 200)) {
                output = (String) json.get("ReplyMsg");
            } else {
                output = (String) json.get("ReplyMessage");
            }
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            httpClient.close();
            return "Error!, Please try again";
        }
    }

}
