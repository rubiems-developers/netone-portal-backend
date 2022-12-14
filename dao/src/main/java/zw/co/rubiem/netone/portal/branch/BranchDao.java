package zw.co.rubiem.netone.portal.branch;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface BranchDao extends BaseDao<Branch> {

    Optional<Branch> findByNameIgnoreCase(String name);

}
