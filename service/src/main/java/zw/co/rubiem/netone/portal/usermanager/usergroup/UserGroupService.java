package zw.co.rubiem.netone.portal.usermanager.usergroup;

import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

public interface UserGroupService extends BaseService<UserGroup, UserGroupRequest, UserGroupUpdateRequest> {
    UserGroup getByName(String name);

    boolean existsByName(String name);

    UserGroup createFromEnum(UserGroupRequest userGroupRequest);

}
