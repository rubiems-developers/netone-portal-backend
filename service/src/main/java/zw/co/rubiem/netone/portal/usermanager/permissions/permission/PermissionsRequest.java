package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import lombok.Data;
import lombok.val;

import javax.validation.constraints.NotBlank;


@Data
public class PermissionsRequest {

    @NotBlank(message = "Permission name should be provided")
    private String name;

    private String description;

    public static PermissionsRequest fromEnum(PermissionsEnum permissions) {
        val context = new PermissionsRequest();
        context.setDescription(permissions.name().replace("_", " "));
        context.setName(permissions.name());
        return context;
    }
}
