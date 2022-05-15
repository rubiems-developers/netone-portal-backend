package zw.co.rubiem.netone.portal.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {

    @NotBlank(message = "City is required!")
    @Column(name = "city", nullable = false)

    private String city;
    @NotBlank(message = "Country is required!")

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "address_line1")
    @NotBlank(message = "Address is required!")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "address_line3")
    private String addressLine3;

    public Address() {
    }

    public Address(String city, String country, String addressLine1, String addressLine2, String addressLine3) {
        this.city = city;
        this.country = country;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }
}
