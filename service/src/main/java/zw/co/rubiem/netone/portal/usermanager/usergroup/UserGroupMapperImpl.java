package zw.co.rubiem.netone.portal.usermanager.usergroup;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserGroupMapperImpl implements UserGroupMapper {

    @Override
    public UserGroup userGroupFromUserGroupRequest(UserGroupRequest userGroupRequest) {
        Objects.requireNonNull(userGroupRequest, "UserGroupRequest must not be null");
        UserGroup userGroup = new UserGroup();
        userGroup.setName(userGroupRequest.getName());
        userGroup.setDescription(userGroupRequest.getDescription());
        return userGroup;
    }

    @Override
    public UserGroup userGroupFromUserGroupUpdateRequest(UserGroup userGroup, UserGroupUpdateRequest userGroupUpdateRequest) {
        Objects.requireNonNull(userGroup, "UserGroup must not be null");
        Objects.requireNonNull(userGroupUpdateRequest, "UserGroupUpdateRequest must not be null");
        userGroup.setName(userGroupUpdateRequest.getName());
        userGroup.setDescription(userGroupUpdateRequest.getDescription());
        return userGroup;
    }

    @Override
    public UserGroupDto userGroupDtoFromUserGroup(UserGroup userGroup) {
        Objects.requireNonNull(userGroup, "UserGroup must not be null");
        UserGroupDto userGroupDto = new UserGroupDto();
        userGroupDto.setId(userGroup.getId());
        userGroupDto.setName(userGroup.getName());
        userGroupDto.setDescription(userGroup.getDescription());
        return userGroupDto;
    }
}
