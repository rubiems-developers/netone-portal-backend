package zw.co.rubiem.netone.portal.domain.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ContactDetails {
    @Embedded
    @Column(nullable = false)
    private Address address;
    @Column(length = 100, unique = true)
    private String email;

    public ContactDetails() {

    }

    public ContactDetails(Address address, String email) {
        this.address = address;
        this.email = email;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
