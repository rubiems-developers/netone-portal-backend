package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.Data;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupDto;

@Data
public class UserAccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private boolean active;
    private UserGroupDto userGroupDto;
}
