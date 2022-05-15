package zw.co.rubiem.netone.portal.dao.airtime;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.airtime.AirtimeRecharge;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;
@Repository
public interface AirtimeRechargeDao extends BaseDao<AirtimeRecharge> {
    Optional<AirtimeRecharge> findByLastModifiedByIgnoreCase(String date);
}
