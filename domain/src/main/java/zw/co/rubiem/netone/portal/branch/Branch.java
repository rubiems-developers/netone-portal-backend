package zw.co.rubiem.netone.portal.branch;

import zw.co.rubiem.netone.portal.commons.demographics.Address;
import zw.co.rubiem.netone.portal.commons.demographics.Location;
import zw.co.rubiem.netone.portal.commons.demographics.PhoneNumber;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Branch extends BaseEntity {

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Branch name is required!")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phoneCountryCode", column = @Column(name = "branch_phone_country_code")),
            @AttributeOverride(name = "operatorCode", column = @Column(name = "branch_operator_code")),
            @AttributeOverride(name = "number", column = @Column(name = "branch_number"))
    })
    private PhoneNumber phoneNumber;

    @Embedded
    private Address address;

    @Embedded
    private Location location;

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
