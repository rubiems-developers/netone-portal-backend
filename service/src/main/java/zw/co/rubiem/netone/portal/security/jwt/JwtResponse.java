package zw.co.rubiem.netone.portal.security.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccount;

import java.util.Arrays;
import java.util.Collection;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private UserAccount userAccount;
    //    private Collection<? extends GrantedAuthority> authorities;
    private String[] authorities;

    public JwtResponse(String accessToken, String username, UserAccount userAccount, Collection<? extends GrantedAuthority> authorities) {
        this.token = accessToken;
        this.username = username;
        this.userAccount = userAccount;
        this.authorities = Arrays.stream(authorities.toArray())
                .map(Object::toString)
                .toArray(String[]::new);
    }

}