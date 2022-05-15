package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import lombok.val;
import org.springframework.stereotype.Service;
import zw.co.trogon.dashboard.commons.jpa.BaseServiceImpl;
import zw.co.trogon.dashboard.usermanager.permissions.Permissions;
import zw.co.trogon.dashboard.usermanager.permissions.PermissionsDao;

import java.util.Collection;

import static java.util.stream.Collectors.toSet;


@Service
public class PermissionsServiceImpl extends BaseServiceImpl<Permissions, PermissionsRequest, PermissionsUpdateRequest> implements PermissionsService {

    private final PermissionsDao permissionsDao;
    private final PermissionsMapper permissionsMapper;

    PermissionsServiceImpl(PermissionsDao permissionsDao, PermissionsMapper permissionsMapper) {
        super(permissionsDao);
        this.permissionsDao = permissionsDao;
        this.permissionsMapper = permissionsMapper;
    }

    @Override
    protected Class<Permissions> getEntityClass() {
        return Permissions.class;
    }

    @Override
    public Permissions create(PermissionsRequest createDto) {
        val optionalPermission = permissionsDao.findByName(createDto.getName());
        if (optionalPermission.isPresent()) {
            val permission = optionalPermission.get();
            permission.setDescription(createDto.getDescription());
            return permissionsDao.save(permission);
        } else {
            val permission = permissionsMapper.permissionsFromPermissionsRequest(createDto);
            return permissionsDao.save(permission);
        }
    }


    public Permissions update(PermissionsUpdateRequest updateDto) {
        val permissionRecord = findById(updateDto.getId());
        Permissions permission = permissionsMapper.permissionsFromPermissionsUpdateRequest(permissionRecord, updateDto);
        return permissionsDao.save(permission);
    }

    @Override
    public Collection<Permissions> create(Collection<PermissionsRequest> createPermissionContexts) {
        Collection<Permissions> permissions = createPermissionContexts.parallelStream()
                .map(createPermissionContext -> {
                    val optionalPermission = permissionsDao.findByName(createPermissionContext.getName());
                    if (optionalPermission.isPresent()) {
                        val permission = optionalPermission.get();
                        permission.setDescription(createPermissionContext.getDescription());
                        return permission;
                    } else {
                        return permissionsMapper.permissionsFromPermissionsRequest(createPermissionContext);
                    }
                })
                .collect(toSet());
        return permissionsDao.saveAll(permissions);
    }

    @Override
    public Collection<Permissions> findByIds(Collection<Long> ids) {
        return permissionsDao.findAllById(ids);
    }
}
