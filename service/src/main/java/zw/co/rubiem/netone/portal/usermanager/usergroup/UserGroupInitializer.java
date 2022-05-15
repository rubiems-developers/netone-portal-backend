package zw.co.rubiem.netone.portal.usermanager.usergroup;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Slf4j
@Configuration
@AllArgsConstructor
public class UserGroupInitializer implements InitializingBean {

    private final UserGroupService userGroupsService;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("### UserGroupService initializer: " + UserGroupEnum.values());
        Stream.of(UserGroupEnum.values())
                .map(UserGroupRequest::fromEnum)
                .forEach(userGroupsService::createFromEnum);
    }
}
