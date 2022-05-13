package zw.co.rubiem.netone.portal.service.airtime.recharge;
import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.airtime.AirtimeRecharge;

import java.util.Objects;
@Component
public class AirtimeRechargeMapperImpl  implements AirtimeRechargeMapper {
    @Override
    public AirtimeRechargeDto airtimeRechargeDtoFromAirtimeRecharge(AirtimeRecharge airtimeRecharge) {
        Objects.requireNonNull(airtimeRecharge, "AirtimeRecharge must not be null");
        AirtimeRechargeDto airtimeRechargeDto = new AirtimeRechargeDto();
        airtimeRechargeDto.setId(airtimeRecharge.getId());
        airtimeRechargeDto.setRecipientNumber(airtimeRecharge.getRecipientNumber());
        airtimeRechargeDto.setRechargeAmount(airtimeRecharge.getRechargeAmount());
        airtimeRechargeDto.setPayerNumber(airtimeRecharge.getPayerNumber());
        airtimeRechargeDto.setPaymentMethod(airtimeRecharge.getPaymentMethod());
        return airtimeRechargeDto;
    }

    @Override
    public AirtimeRecharge airtimeRechargeFromAirtimeRechargeRequest(AirtimeRechargeRequest rechargeRequest) {
        Objects.requireNonNull(rechargeRequest, "AirtimeRechargeRequest must not be null");
        AirtimeRecharge airtimeRecharge = new AirtimeRecharge();
        airtimeRecharge.setRecipientNumber(rechargeRequest.getRecipientNumber());
        airtimeRecharge.setRechargeAmount(rechargeRequest.getRechargeAmount());
        airtimeRecharge.setPayerNumber(rechargeRequest.getPayerNumber());
        airtimeRecharge.setPaymentMethod(rechargeRequest.getPaymentMethod());
        return airtimeRecharge;
    }
}
