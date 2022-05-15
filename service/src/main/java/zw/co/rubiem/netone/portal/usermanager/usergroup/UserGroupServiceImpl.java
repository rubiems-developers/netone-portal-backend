package zw.co.rubiem.netone.portal.usermanager.usergroup;

import lombok.val;
import org.springframework.stereotype.Service;
import zw.co.trogon.dashboard.commons.exceptions.InvalidRequestException;
import zw.co.trogon.dashboard.commons.jpa.BaseServiceImpl;

import javax.validation.ConstraintViolationException;

@Service
class UserGroupServiceImpl extends BaseServiceImpl<UserGroup, UserGroupRequest, UserGroupUpdateRequest> implements UserGroupService {

    private final UserGroupDao userGroupDao;
    private final UserGroupMapper userGroupMapper;

    UserGroupServiceImpl(UserGroupDao userGroupDao, UserGroupMapper userGroupMapper) {
        super(userGroupDao);
        this.userGroupDao = userGroupDao;
        this.userGroupMapper = userGroupMapper;
    }

    @Override
    protected Class<UserGroup> getEntityClass() {
        return UserGroup.class;
    }

    @Override
    public UserGroup create(UserGroupRequest request) {
        boolean detailsExists = userGroupDao.existsByName(request.getName());
        if (detailsExists) {
            throw new InvalidRequestException("UserGroup with the same name already exists");
        }
        UserGroup userGroup = userGroupMapper.userGroupFromUserGroupRequest(request);
        return userGroupDao.save(userGroup);
    }

    @Override
    public UserGroup createFromEnum(UserGroupRequest request) {
        val optionalUserGroup = userGroupDao.findByName(request.getName());
        UserGroup userGroup;
        if (optionalUserGroup.isPresent()) {
            userGroup = optionalUserGroup.get();
            userGroup.setDescription(request.getDescription());
        } else {
            userGroup = userGroupMapper.userGroupFromUserGroupRequest(request);
        }
        return userGroupDao.save(userGroup);
    }

    @Override
    public UserGroup update(UserGroupUpdateRequest request) {
        UserGroup userGroupRecord = findById(request.getId());
        UserGroup userGroup = userGroupMapper.userGroupFromUserGroupUpdateRequest(userGroupRecord, request);
        return userGroupDao.save(userGroup);
    }

    @Override
    public void delete(Long id) {
        try {
            super.delete(id);
        } catch (ConstraintViolationException var3) {
            throw new InvalidRequestException("You can not delete this record is might be used by another record");
        }
    }

    @Override
    public UserGroup getByName(String name) {
        return userGroupDao.getByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return userGroupDao.existsByName(name);
    }

}