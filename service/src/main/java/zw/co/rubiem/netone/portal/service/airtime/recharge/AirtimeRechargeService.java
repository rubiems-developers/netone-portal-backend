package zw.co.rubiem.netone.portal.service.airtime.recharge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.airtime.AirtimeRecharge;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.service.airtime.balance.BalanceEnquiryDto;

import java.util.Collection;

public interface AirtimeRechargeService extends BaseService<AirtimeRecharge, AirtimeRechargeRequest, AirtimeRechargeUpdateRequest> {
    AirtimeRechargeDto findAirtimeRechargeById(Long id);
    Page<AirtimeRechargeDto> findAirtimeRecharges(Pageable pageable, String searchQuery);
    Collection<AirtimeRechargeDto> findAllAirtimeRecharges();

}
