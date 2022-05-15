package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserAccountUpdateRequest {

    private long id;

    @NotBlank(message = "First name should be provided")
    @Size(max = 255, message = "First name should not be more than 255 characters")
    private String firstName;

    @NotBlank(message = "Last name should be provided")
    @Size(max = 255, message = "Last should not be more than 255 characters")
    private String lastName;

    private long groupId;

}
