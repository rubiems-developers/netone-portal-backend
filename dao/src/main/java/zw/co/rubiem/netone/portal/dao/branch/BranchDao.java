package zw.co.rubiem.netone.portal.dao.branch;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.branch.Branch;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface BranchDao extends BaseDao<Branch> {

    Optional<Branch> findByNameIgnoreCase(String name);

}
