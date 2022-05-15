package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import zw.co.trogon.dashboard.commons.jpa.BaseService;
import zw.co.trogon.dashboard.usermanager.permissions.Permissions;

import java.util.Collection;

public interface PermissionsService extends BaseService<Permissions, PermissionsRequest, PermissionsUpdateRequest> {

    Collection<Permissions> create(Collection<PermissionsRequest> createPermissionContexts);

    Collection<Permissions> findByIds(Collection<Long> ids);
}
