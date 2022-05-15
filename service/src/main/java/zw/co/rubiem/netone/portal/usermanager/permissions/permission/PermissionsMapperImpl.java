package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;

import java.util.Objects;

@Component
public class PermissionsMapperImpl implements PermissionsMapper {

    @Override
    public Permissions permissionsFromPermissionsRequest(PermissionsRequest permissionsRequest) {
        Objects.requireNonNull(permissionsRequest, "PermissionsRequest must not be null");
        Permissions permissions = new Permissions();
        permissions.setName(permissionsRequest.getName());
        permissions.setDescription(permissionsRequest.getDescription());
        return permissions;
    }

    @Override
    public Permissions permissionsFromPermissionsUpdateRequest(Permissions permissions, PermissionsUpdateRequest permissionsUpdateRequest) {
        Objects.requireNonNull(permissions, "Permissions must not be null");
        Objects.requireNonNull(permissionsUpdateRequest, "PermissionsUpdateRequest must not be null");
        permissions.setName(permissionsUpdateRequest.getName());
        permissions.setDescription(permissionsUpdateRequest.getDescription());
        return permissions;
    }

    @Override
    public PermissionsDto permissionsDtoFromPermissions(Permissions permissions) {
        Objects.requireNonNull(permissions, "Permissions must not be null");
        PermissionsDto permissionsDto = new PermissionsDto();
        permissionsDto.setId(permissions.getId());
        permissionsDto.setName(permissions.getName());
        permissionsDto.setDescription(permissions.getDescription());
        return permissionsDto;
    }
}
