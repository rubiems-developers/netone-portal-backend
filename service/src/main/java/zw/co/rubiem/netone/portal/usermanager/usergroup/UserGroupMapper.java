package zw.co.rubiem.netone.portal.usermanager.usergroup;

public interface UserGroupMapper {
    UserGroup userGroupFromUserGroupRequest(UserGroupRequest userGroupRequest);

    UserGroup userGroupFromUserGroupUpdateRequest(UserGroup userGroup, UserGroupUpdateRequest userGroupUpdateRequest);

    UserGroupDto userGroupDtoFromUserGroup(UserGroup userGroup);
}
