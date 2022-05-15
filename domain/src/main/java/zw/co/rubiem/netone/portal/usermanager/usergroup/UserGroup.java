package zw.co.rubiem.netone.portal.usermanager.usergroup;

import lombok.Data;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Entity;

@Data
@Entity
public class UserGroup extends BaseEntity {

    private String name;

    private String description;

}
