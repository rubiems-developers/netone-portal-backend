package zw.co.rubiem.netone.portal.usermanager.useraccount;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserAccountDao extends BaseDao<UserAccount> {

    Optional<UserAccount> findByUsername(String username);

    boolean existsByUsername(String username);

    Collection<UserAccount> findByGroup_Id(long groupId);

}
