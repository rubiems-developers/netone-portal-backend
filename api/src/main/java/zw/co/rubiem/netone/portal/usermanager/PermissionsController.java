package zw.co.rubiem.netone.portal.usermanager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.usermanager.permissions.Permissions;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsRequest;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsService;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsUpdateRequest;

import java.util.Collection;


@RestController
@CrossOrigin
@RequestMapping("")
@Api(tags = "Permissions")
public class PermissionsController {

    private final PermissionsService permissionService;

    public PermissionsController(PermissionsService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/v1/permissions")
    @ApiOperation("Get Permissions")
    public Page<Permissions> getAll(@PageableDefault Pageable pageable, @RequestParam(required = false) String search) {
        return permissionService.findAll(pageable, search);
    }

    @GetMapping("/v1/permissions/all")
    @ApiOperation("Get All Permissions")
    public Collection<Permissions> getAll() {
        return permissionService.findAll();
    }

    @GetMapping("/v1/permission/{permissionId}")
    @ApiOperation("Get a Permission by Id")
    public Permissions getPermission(@PathVariable long permissionId) {
        return permissionService.findById(permissionId);
    }

    @PostMapping("/system/v1/permissions")
    @ApiOperation("Create Permission")
    //@PreAuthorize("hasAuthority('CREATE_PERMISSION')")
    public Permissions create(@RequestBody PermissionsRequest permissionsRequest) {
        return permissionService.create(permissionsRequest);
    }

    @PostMapping("/system/v1/permissions/bulk")
    @ApiOperation("Create Bulk Permissions")
    //@PreAuthorize("hasAuthority('CREATE_PERMISSION')")
    public Collection<Permissions> create(@RequestBody Collection<PermissionsRequest> permissionsRequestCollection) {
        return permissionService.create(permissionsRequestCollection);
    }

    @PutMapping("/v1/permissions/{permissionId}")
    @ApiOperation("Update Permission")
    @PreAuthorize("hasAuthority('UPDATE_PERMISSION')")
    public Permissions update(@RequestBody PermissionsUpdateRequest permissionsUpdateRequest, @PathVariable long permissionId) {
        permissionsUpdateRequest.setId(permissionId);
        return permissionService.update(permissionsUpdateRequest);
    }

}

