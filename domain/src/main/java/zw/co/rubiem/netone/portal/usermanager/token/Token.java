package zw.co.rubiem.netone.portal.usermanager.token;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;
import zw.co.rubiem.netone.portal.usermanager.useraccount.UserAccount;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_tokens_users"))
    private UserAccount userAccount;

    private boolean used;

    private boolean expired;

    private LocalDateTime expiryDate;

    public Token(UserAccount userAccount) {
        this.userAccount = userAccount;
        this.expiryDate = LocalDateTime.now().plusHours(24);
    }

    @PostLoad
    @PostUpdate
    public void checkExpiry() {
        this.expired = this.expiryDate.isBefore(LocalDateTime.now());
    }
}
