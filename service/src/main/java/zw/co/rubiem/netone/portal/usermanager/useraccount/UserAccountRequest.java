package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserAccountRequest {

    @NotBlank(message = "First name should be provided")
    @Size(max = 50, message = "First name should not be more than 50 characters")
    private String firstName;

    @NotBlank(message = "Last name should be provided")
    @Size(max = 50, message = "Last should not be more than 50 characters")
    private String lastName;

    @NotBlank(message = "Username should be provided")
    @Size(max = 50, message = "Username should not be more than 50 characters")
    private String username;

    @Email(message = "A valid email should be provided")
    private String email;

    @NotBlank(message = "Username should be provided")
    private String password; //to be changed to a temp password that is updated after a create

    @NotBlank(message = "Username should be provided")
    private Long groupId;

}
