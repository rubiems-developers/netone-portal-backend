package zw.co.rubiem.netone.portal.usermanager.useraccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroup;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;

import static java.util.Objects.isNull;

@Data
@Entity
public class UserAccount extends BaseEntity implements UserDetails {

    @Column(unique = true, updatable = false, nullable = false)
    @Size(min = 3, max = 50)
    private String username;

    @Email
    @Column(unique = true, updatable = false, nullable = false)
    @Size(max = 100)
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(min = 6, max = 250)
    private String password;

    private String firstName;

    private String lastName;

    @Transient
    private String fullName;

    private boolean isActive;

    @ManyToOne
    private UserGroup group;

    @Transient
    private Collection<GrantedAuthority> authorities;

    public UserAccount() {
    }

    public UserAccount(String firstName, String username, String email, String password) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        if (isNull(authorities)) {
            authorities = new HashSet<>();
        }
        return authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public void addPermission(SimpleGrantedAuthority simpleGrantedAuthority) {
        this.getAuthorities().add(simpleGrantedAuthority);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", group=" + group +
                '}';
    }

    @PostLoad
    public void postLoad() {
        this.fullName = (isNull(this.fullName)) ? this.firstName + " " + this.lastName : this.fullName;
    }

}
