package zw.co.rubiem.netone.portal.usermanager.permissions;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.commons.jpa.BaseDao;

import java.util.Optional;

@Repository
public interface PermissionsDao extends BaseDao<Permissions> {

    Optional<Permissions> findByName(String name);

}


