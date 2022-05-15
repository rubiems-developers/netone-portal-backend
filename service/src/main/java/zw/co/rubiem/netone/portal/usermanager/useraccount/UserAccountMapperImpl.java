package zw.co.rubiem.netone.portal.usermanager.useraccount;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroup;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupMapper;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupService;

import java.util.Objects;

@Component
public class UserAccountMapperImpl implements UserAccountMapper {

    private final UserGroupMapper userGroupMapper;
    private final UserGroupService userGroupService;
    private final PasswordEncoder passwordEncoder;

    public UserAccountMapperImpl(UserGroupMapper userGroupMapper, UserGroupService userGroupService, PasswordEncoder passwordEncoder) {
        this.userGroupMapper = userGroupMapper;
        this.userGroupService = userGroupService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount userAccountFromUserAccountRequest(UserAccountRequest userAccountRequest) {
        Objects.requireNonNull(userAccountRequest, "UserAccountRequest must not be null");
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(userAccountRequest.getFirstName());
        userAccount.setLastName(userAccountRequest.getLastName());
        userAccount.setUsername(userAccountRequest.getUsername());
        userAccount.setPassword(passwordEncoder.encode(userAccountRequest.getPassword()));
        userAccount.setActive(false);
        UserGroup userGroup = userGroupService.findById(userAccountRequest.getGroupId());
        userAccount.setGroup(userGroup);
        return userAccount;
    }

    @Override
    public UserAccount userAccountFromUserAccountUpdateRequest(UserAccount userAccount, UserAccountUpdateRequest userAccountUpdateRequest) {
        Objects.requireNonNull(userAccount, "UserAccount must not be null");
        Objects.requireNonNull(userAccountUpdateRequest, "UserAccountUpdateRequest must not be null");
        userAccount.setFirstName(userAccountUpdateRequest.getFirstName());
        userAccount.setLastName(userAccountUpdateRequest.getLastName());
        UserGroup userGroup = userGroupService.findById(userAccountUpdateRequest.getGroupId());
        userAccount.setGroup(userGroup);
        return userAccount;
    }

    @Override
    public UserAccountDto userAccountDtoFromUserAccount(UserAccount userAccount) {
        Objects.requireNonNull(userAccount, "UserAccount must not be null");
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setId(userAccount.getId());
        userAccountDto.setFirstName(userAccount.getFirstName());
        userAccountDto.setLastName(userAccount.getLastName());
        userAccountDto.setUsername(userAccount.getUsername());
        userAccountDto.setActive(userAccount.isActive());
        userAccountDto.setUserGroupDto(userGroupMapper.userGroupDtoFromUserGroup(userAccount.getGroup()));
        return userAccountDto;
    }

}
