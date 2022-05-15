package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import zw.co.rubiem.netone.portal.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;

import java.util.Collection;

public interface PermissionsService extends BaseService<Permissions, PermissionsRequest, PermissionsUpdateRequest> {

    Collection<Permissions> create(Collection<PermissionsRequest> createPermissionContexts);

    Collection<Permissions> findByIds(Collection<Long> ids);
}
