package zw.co.rubiem.netone.portal.airtime.recharge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.airtime.AirtimeRecharge;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface AirtimeRechargeService extends BaseService<AirtimeRecharge, AirtimeRechargeRequest, AirtimeRechargeUpdateRequest> {
    AirtimeRechargeDto findAirtimeRechargeById(Long id);
    Page<AirtimeRechargeDto> findAirtimeRecharges(Pageable pageable, String searchQuery);
    Collection<AirtimeRechargeDto> findAllAirtimeRecharges();

}
