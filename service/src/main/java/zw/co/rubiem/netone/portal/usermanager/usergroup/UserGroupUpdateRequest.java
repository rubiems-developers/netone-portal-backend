package zw.co.rubiem.netone.portal.usermanager.usergroup;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserGroupUpdateRequest {

    private Long id;

    @NotBlank(message = "Group name should be provided")
    private String name;

    private String description;
}
