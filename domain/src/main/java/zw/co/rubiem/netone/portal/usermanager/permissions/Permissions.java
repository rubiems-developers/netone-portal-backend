package zw.co.rubiem.netone.portal.usermanager.permissions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Permissions extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;

}