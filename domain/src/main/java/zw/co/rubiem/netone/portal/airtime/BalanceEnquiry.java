package zw.co.rubiem.netone.portal.airtime;

import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
@Entity
public class BalanceEnquiry extends BaseEntity {
    @NotBlank(message = "Phone Number cannot be empty")
    @Column(nullable = false)
    private String phoneNumber;

    private String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
