package zw.co.rubiem.netone.portal.airtime.recharge;
import zw.co.rubiem.netone.portal.airtime.AirtimeRecharge;


public interface AirtimeRechargeMapper {
    AirtimeRechargeDto airtimeRechargeDtoFromAirtimeRecharge (AirtimeRecharge airtimeRecharge);
    AirtimeRecharge airtimeRechargeFromAirtimeRechargeRequest(AirtimeRechargeRequest rechargeRequest);
}
