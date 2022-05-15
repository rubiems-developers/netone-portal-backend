package zw.co.rubiem.netone.portal.usermanager.useraccount;

import lombok.Data;

@Data
public class ActivateOrDeActivateUserRequest {

    private long userAccountId;
    private boolean isActive;

}
