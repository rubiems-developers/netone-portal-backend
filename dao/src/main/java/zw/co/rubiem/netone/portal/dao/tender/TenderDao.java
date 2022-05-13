package zw.co.rubiem.netone.portal.dao.tender;


import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.domain.tender.Tender;

import java.util.Optional;
@Repository
public interface TenderDao extends BaseDao<Tender> {
    Optional<Tender> findByTenderTitleIgnoreCase(String title);
}
