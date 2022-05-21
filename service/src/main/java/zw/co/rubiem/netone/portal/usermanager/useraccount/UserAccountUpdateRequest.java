package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserAccountUpdateRequest {

    @NotBlank(message = "UserAccount Id should be provided")
    private Long id;

    @NotBlank(message = "First name should be provided")
    @Size(max = 255, message = "First name should not be more than 255 characters")
    private String firstName;

    @NotBlank(message = "Last name should be provided")
    @Size(max = 255, message = "Last should not be more than 255 characters")
    private String lastName;

    @Email(message = "A valid email should be provided")
    private String email;

    @NotBlank(message = "Group Id should be provided")
    private Long groupId;

}
