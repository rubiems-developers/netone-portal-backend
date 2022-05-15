package zw.co.rubiem.netone.portal.usermanager.permissions.permission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Slf4j
@Configuration
public class PermissionsInitializer implements InitializingBean {

    private final PermissionsService permissionService;

    public PermissionsInitializer(PermissionsService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Permissions initializer" + PermissionsEnum.values().toString());
        Stream.of(PermissionsEnum.values())
                .map(PermissionsRequest::fromEnum)
                .forEach(permissionService::create);
    }
}
