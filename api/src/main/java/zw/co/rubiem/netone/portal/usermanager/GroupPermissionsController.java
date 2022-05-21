package zw.co.rubiem.netone.portal.usermanager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.usermanager.permissions.GroupPermission;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;
import zw.co.rubiem.netone.portal.usermanager.permissions.group.GroupPermissionService;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("")
@Api(tags = "Group Permissions")
public class GroupPermissionsController {

    private final GroupPermissionService groupPermissionService;

    public GroupPermissionsController(GroupPermissionService groupPermissionService) {
        this.groupPermissionService = groupPermissionService;
    }

    @GetMapping("/v1/group/{groupId}/permissions")
    @ApiOperation("Get Group Permissions")
    public Page<GroupPermission> getAll(Pageable pageable, @PathVariable long groupId) {
        return groupPermissionService.findByGroupId(groupId, pageable);
    }

    @GetMapping("/v1/group/{groupId}/permissions/all")
    @ApiOperation("Get All Group Permissions")
    public Collection<GroupPermission> getAll(@PathVariable long groupId) {
        return groupPermissionService.findAllByGroupId(groupId);
    }

    @GetMapping("/v1/permissions/{groupId}/permissions")
    @ApiOperation("Get Group Permissions")
    public Page<Permissions> getPermissionsForGroup(Pageable pageable, @PathVariable long groupId) {
        return groupPermissionService.getPermissionsThatBelongToGroup(groupId, pageable);
    }

    @GetMapping("/v1/permissions/{groupId}/permissions/all")
    @ApiOperation("Get All Group Permissions")
    public Collection<Permissions> getAllPermissionsForGroup(@PathVariable long groupId) {
        return groupPermissionService.getPermissionsThatBelongToGroup(groupId);
    }

    @PatchMapping("/v1/group-permissions/revoke")
    @ApiOperation("Delete Group Permission")
    public void delete(@RequestParam long groupPermissionId) {
        groupPermissionService.delete(groupPermissionId);
    }

    @PatchMapping("/v1/group-permissions/revoke-bulk")
    @ApiOperation("Delete Group Permissions")
    public void delete(@RequestBody Collection<Long> groupPermissionIds) {
        groupPermissionService.delete(groupPermissionIds);
    }

    @PostMapping("/v1/group-permissions")
    @ApiOperation("Create Group Permission")
    public GroupPermission create(@RequestParam long groupId, @RequestParam long permissionId) {
        return groupPermissionService.create(groupId, permissionId);
    }

    @PostMapping("/v1/group-permissions/bulk")
    @ApiOperation("Create Group Permissions")
    public Collection<GroupPermission> create(@RequestParam long groupId, @RequestBody Collection<Long> permissionIds) {
        return groupPermissionService.create(groupId, permissionIds);
    }

    @GetMapping("/v1/group-permissions/unassigned/{groupId}")
    @ApiOperation("Get unassigned permissions admin")
    public Collection<Permissions> unassignedPermissions(@PathVariable long groupId) {
        return groupPermissionService.findUnassignedPermissions(groupId);
    }

}
