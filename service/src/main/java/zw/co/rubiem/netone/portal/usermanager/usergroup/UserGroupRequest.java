package zw.co.rubiem.netone.portal.usermanager.usergroup;

import lombok.Data;
import lombok.val;

import javax.validation.constraints.NotBlank;

/**
 * @author nyabindenyasha
 * @created 08/04/2021
 * @project - procurement-system
 **/

@Data
public class UserGroupRequest {

    @NotBlank(message = "Group name should be provided")
    private String name;

    private String description;

    public static UserGroupRequest fromEnum(UserGroupEnum userGroupEnum) {

        val context = new UserGroupRequest();
        context.setDescription(userGroupEnum.name().replace("_", " "));
        context.setName(userGroupEnum.name());
        return context;
    }
}
