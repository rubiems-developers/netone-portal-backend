package zw.co.rubiem.netone.portal.usermanager.usergroup;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface UserGroupDao extends BaseDao<UserGroup> {

    Optional<UserGroup> findByName(String name);

    UserGroup getByName(String name);

    boolean existsByName(String name);
}
