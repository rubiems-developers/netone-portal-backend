package zw.co.trogon.dashboard.security.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.co.trogon.dashboard.usermanager.permissions.GroupPermission;
import zw.co.trogon.dashboard.usermanager.permissions.Permissions;
import zw.co.trogon.dashboard.usermanager.permissions.group.GroupPermissionService;
import zw.co.trogon.dashboard.usermanager.useraccount.UserAccount;
import zw.co.trogon.dashboard.usermanager.useraccount.UserAccountService;


@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAccountService userAccountService;

    private final GroupPermissionService groupPermissionService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccount user = userAccountService.findByUsername(username);

        val groupAuthorities = groupPermissionService.findAllByGroupId(user.getGroup().getId());
        groupAuthorities.stream().map(GroupPermission::getPermission)
                .map(Permissions::getName)
                .map(SimpleGrantedAuthority::new)
                .forEach(user::addPermission);
        UserPrinciple userPrinciple = new UserPrinciple();

        return userPrinciple.build(user);
    }

}