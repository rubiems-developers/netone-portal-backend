package zw.co.rubiem.netone.portal.usermanager.useraccount;

public interface UserAccountMapper {
    UserAccount userAccountFromUserAccountRequest(UserAccountRequest userAccountRequest);
    UserAccount userAccountFromUserAccountUpdateRequest(UserAccount userAccount, UserAccountUpdateRequest userAccountUpdateRequest);
    UserAccountDto userAccountDtoFromUserAccount(UserAccount userAccount);
}
