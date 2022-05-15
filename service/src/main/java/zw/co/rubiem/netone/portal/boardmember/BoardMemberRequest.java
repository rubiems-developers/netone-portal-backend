package zw.co.rubiem.netone.portal.boardmember;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BoardMemberRequest {

    @NotBlank(message = "BoardMember title is required")
    @Size(max = 10)
    private String title;

    @NotBlank(message = "BoardMember First name is required")
    @Size(min = 3, max = 100)
    private String firstName;

    @NotBlank(message = "BoardMember Last name is required")
    @Size(min = 3, max = 100)
    private String lastName;

    @NotBlank(message = "BoardMember profile is required")
    private String profileDescription;

    private String imageUrl;

}
