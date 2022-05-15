package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;

public interface PermissionsMapper {
    Permissions permissionsFromPermissionsRequest(PermissionsRequest permissionsRequest);

    Permissions permissionsFromPermissionsUpdateRequest(Permissions permissions, PermissionsUpdateRequest permissionsUpdateRequest);

    PermissionsDto permissionsDtoFromPermissions(Permissions permissions);
}
