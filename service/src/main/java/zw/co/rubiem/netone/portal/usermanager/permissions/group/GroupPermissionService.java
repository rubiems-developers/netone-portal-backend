package zw.co.rubiem.netone.portal.usermanager.permissions.group;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.usermanager.permissions.GroupPermission;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;

import java.util.Collection;

public interface GroupPermissionService {

    GroupPermission create(GroupPermissionRequest groupPermissionRequest);

    GroupPermission create(long groupId, long permissionId);

    Collection<GroupPermission> create(long groupId, Collection<Long> permissionIds);

    Collection<GroupPermission> createFromPermissions(long groupId, Collection<Permissions> permissions);

    Collection<GroupPermission> findAllByGroupId(long groupId);

    Page<GroupPermission> findByGroupId(long id, Pageable pageable);

    void delete(long groupPermissionId);

    void delete(Collection<Long> groupPermissionIds);

    Collection<Permissions> getPermissionsThatBelongToGroup(long groupId);

    Page<Permissions> getPermissionsThatBelongToGroup(long groupId, Pageable pageable);

    Collection<Permissions> findUnassignedPermissions(long groupId);

}
