package zw.co.rubiem.netone.portal.usermanager.permissions.group;

import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.commons.utils.PageBuilder;
import zw.co.rubiem.netone.portal.usermanager.permissions.GroupPermission;
import zw.co.rubiem.netone.portal.usermanager.permissions.GroupPermissionsDao;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsEnum;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsService;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Service
class GroupPermissionServiceImpl implements GroupPermissionService {

    private final UserGroupService userGroupService;
    private final PermissionsService permissionsService;
    private final GroupPermissionsDao groupPermissionsDao;
    private final PageBuilder<Permissions> pageBuilder;

    GroupPermissionServiceImpl(UserGroupService userGroupService, PermissionsService permissionsService, GroupPermissionsDao groupPermissionsDao, PageBuilder pageBuilder) {
        this.userGroupService = userGroupService;
        this.permissionsService = permissionsService;
        this.groupPermissionsDao = groupPermissionsDao;
        this.pageBuilder = pageBuilder;
    }

    @Override
    public GroupPermission create(GroupPermissionRequest request) {
        val group = userGroupService.findById(request.getGroupId());
        val permission = permissionsService.findById(request.getPermissionId());
        val permssionEnum = PermissionsEnum.valueOf(permission.getName());
        if (permssionEnum.isForAdminOnly() && !(group.getName().equalsIgnoreCase("ADMIN") || group.getName().equalsIgnoreCase("ADMINS")))
            throw new InvalidRequestException("This permission is for admins only. Consider upgrading user(s) in that group to admin group.");
        val optionalPermission = groupPermissionsDao.findByUserGroup_IdAndPermission_Id(group.getId(), permission.getId());
        if (!optionalPermission.isEmpty()) {
            return optionalPermission.get(0);
        }
        val groupPermission = new GroupPermission(group, permission);
        return groupPermissionsDao.save(groupPermission);
    }

    @Override
    public GroupPermission create(long groupId, long permissionId) {
        val optionalPermission = groupPermissionsDao.findByUserGroup_IdAndPermission_Id(groupId, permissionId);
        if (!optionalPermission.isEmpty()) {
            return optionalPermission.get(0);
        }
        val group = userGroupService.findById(groupId);
        val permission = permissionsService.findById(permissionId);
        val permssionEnum = PermissionsEnum.valueOf(permission.getName());
        if (permssionEnum.isForAdminOnly() && !(group.getName().equalsIgnoreCase("ADMIN") || group.getName().equalsIgnoreCase("ADMINS")))
            throw new InvalidRequestException("This permission is for admins only. Consider upgrading user(s) in that group to admin group.");
        val groupPermission = new GroupPermission(group, permission);
        return groupPermissionsDao.save(groupPermission);
    }

    @Override
    public Collection<GroupPermission> create(long groupId, Collection<Long> permissionIds) {
        val group = userGroupService.findById(groupId);
        val permissions = permissionsService.findByIds(permissionIds);
        val existing = groupPermissionsDao.findByUserGroup_Id(groupId)
                .stream().map(GroupPermission::getPermission)
                .collect(toSet());
        permissions.forEach(permission -> {
            val permssionEnum = PermissionsEnum.valueOf(permission.getName());
            if (permssionEnum.isForAdminOnly())
                permissions.remove(permission);
        });
        permissions.removeAll(existing);
        val groupPermissions = permissions.parallelStream()
                .map(permission -> new GroupPermission(group, permission))
                .collect(toSet());
        return groupPermissionsDao.saveAll(groupPermissions);
    }

    @Override
    public Collection<GroupPermission> createFromPermissions(long groupId, Collection<Permissions> permissions) {
        val group = userGroupService.findById(groupId);
        val existing = groupPermissionsDao.findByUserGroup_Id(groupId)
                .stream().map(GroupPermission::getPermission)
                .collect(toSet());
        permissions.removeAll(existing);
        val groupPermissions = permissions.parallelStream()
                .map(permission -> new GroupPermission(group, permission))
                .collect(toSet());
        return groupPermissionsDao.saveAll(groupPermissions);
    }

    @Override
    public Collection<GroupPermission> findAllByGroupId(long groupId) {
        return groupPermissionsDao.findByUserGroup_Id(groupId);
    }

    @Override
    public Page<GroupPermission> findByGroupId(long id, Pageable pageable) {
        return groupPermissionsDao.findByUserGroup_Id(id, pageable);
    }

    @Override
    public Collection<Permissions> getPermissionsThatBelongToGroup(long groupId) {
        val groupPermissions = findAllByGroupId(groupId);
        Collection<Permissions> permissionsThatBelongToGroup = new ArrayList<>();
        if (!groupPermissions.isEmpty())
            groupPermissions.forEach(groupPermission -> {
                permissionsThatBelongToGroup.add(groupPermission.getPermission());
            });
        return permissionsThatBelongToGroup;
    }

    @Override
    public Page<Permissions> getPermissionsThatBelongToGroup(long groupId, Pageable pageable) {

        val permissions = (List<Permissions>) getPermissionsThatBelongToGroup(groupId);

        return pageBuilder.collectionToPage(permissions, pageable);

    }

    @Override
    public void delete(long groupPermissionId) {
        groupPermissionsDao.deleteById(groupPermissionId);
    }

    @Override
    @Transactional
    public void delete(Collection<Long> groupPermissionIds) {
        groupPermissionsDao.deleteAllByIds(groupPermissionIds);
    }

    @Override
    public Collection<Permissions> findUnassignedPermissions(long groupId) {
        val allPermissions = permissionsService.findAll();
        val assignedPermissions = groupPermissionsDao.findByUserGroup_Id(groupId)
                .parallelStream()
                .map(GroupPermission::getPermission)
                .collect(toList());

        allPermissions.removeAll(assignedPermissions);

        return allPermissions;
    }

}
