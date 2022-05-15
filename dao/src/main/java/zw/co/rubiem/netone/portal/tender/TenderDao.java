package zw.co.rubiem.netone.portal.tender;


import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;
@Repository
public interface TenderDao extends BaseDao<Tender> {
    Optional<Tender> findByTenderTitleIgnoreCase(String title);
}
