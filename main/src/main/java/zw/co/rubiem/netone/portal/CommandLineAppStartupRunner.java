package zw.co.rubiem.netone.portal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.usermanager.permissions.group.GroupPermissionService;
import zw.co.rubiem.netone.portal.usermanager.permissions.permission.PermissionsService;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccountRequest;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccountService;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupEnum;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroupService;


@Slf4j
@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final UserGroupService userGroupService;
    private final UserAccountService userAccountService;
    private final PermissionsService permissionsService;
    private final GroupPermissionService groupPermissionService;

    @Override
    public void run(String... args) throws Exception {

        try {

            val adminUserExists = userAccountService.existsByUsername("admin");

            if (!adminUserExists) {

                val userGoup = userGroupService.getByName(UserGroupEnum.ADMIN.name());

                val permissions = permissionsService.findAll();

                groupPermissionService.createFromPermissions(userGoup.getId(), permissions);

                val adminUserCreateContext = new UserAccountRequest();
                adminUserCreateContext.setFirstName("Admin");
                adminUserCreateContext.setLastName("Admin");
                adminUserCreateContext.setGroupId(userGoup.getId());
                adminUserCreateContext.setGroupId(userGoup.getId());
                adminUserCreateContext.setPassword("admin@123");
                adminUserCreateContext.setUsername("admin");
                userAccountService.create(adminUserCreateContext);
            }
        } catch (Exception e) {
            log.info("Exception @ CommandLineRunner: " + e.getMessage());
        }
    }
}
