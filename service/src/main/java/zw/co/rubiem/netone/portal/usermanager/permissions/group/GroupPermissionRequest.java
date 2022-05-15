package zw.co.rubiem.netone.portal.usermanager.permissions.group;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GroupPermissionRequest {

    @NotNull(message = "UserGroup should be provided.")
    private Long groupId;

    @NotNull(message = "Permission should be provided.")
    private Long permissionId;

}
