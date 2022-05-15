package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class PermissionsUpdateRequest {

    private Long id;

    @NotBlank(message = "Permission name should be provided")
    private String name;

    private String description;

}
