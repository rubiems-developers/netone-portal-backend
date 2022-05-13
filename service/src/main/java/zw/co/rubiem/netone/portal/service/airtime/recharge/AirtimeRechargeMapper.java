package zw.co.rubiem.netone.portal.service.airtime.recharge;
import zw.co.rubiem.netone.portal.domain.airtime.AirtimeRecharge;


public interface AirtimeRechargeMapper {
    AirtimeRechargeDto airtimeRechargeDtoFromAirtimeRecharge (AirtimeRecharge airtimeRecharge);
    AirtimeRecharge airtimeRechargeFromAirtimeRechargeRequest(AirtimeRechargeRequest rechargeRequest);
}
