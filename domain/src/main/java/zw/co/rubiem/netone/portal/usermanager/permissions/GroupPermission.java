package zw.co.rubiem.netone.portal.usermanager.permissions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;
import zw.co.rubiem.netone.portal.usermanager.usergroup.UserGroup;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "group_permissions")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupPermission extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_group_permissions_groups"))
    private UserGroup userGroup;

    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_group_permissions_permissions"))
    private Permissions permission;

    public GroupPermission(UserGroup userGroup, Permissions permission) {
        this.userGroup = userGroup;
        this.permission = permission;
    }

}
