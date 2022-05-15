package zw.co.rubiem.netone.portal.usermanager.useraccount;

import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface UserAccountService extends BaseService<UserAccount, UserAccountRequest, UserAccountUpdateRequest> {

    UserAccount findByUsername(String username);

    Collection<UserAccount> findByGroup(long groupId);

    void forgotPassword(String username);

    UserAccount updatePassword(UpdatePasswordContext updatePasswordContext);

    void resetPassword(ResetPasswordContext resetPasswordContext);

    boolean existsByUsername(String username);

    UserAccount activateOrDeActivate(long userAccountId, boolean isActive);

    void verifyUser(String tokenValue);

}


