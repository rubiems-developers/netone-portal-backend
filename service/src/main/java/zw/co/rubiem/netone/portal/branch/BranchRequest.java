package zw.co.rubiem.netone.portal.branch;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import zw.co.rubiem.netone.portal.commons.demographics.Address;
import zw.co.rubiem.netone.portal.commons.demographics.Location;
import zw.co.rubiem.netone.portal.commons.demographics.PhoneNumber;

import javax.validation.constraints.NotBlank;

@Data
public class BranchRequest {

    @NotBlank(message = "Branch name is required!")
    private String name;

    @NotBlank(message = "Branch Phone Number Is required!")
    private String phoneNumber;

    @NotBlank(message = "City is required!")
    private String city;

    @NotBlank(message = "Country is required!")
    private String country;

    @NotBlank(message = "Address is required!")
    private String addressLine1;

    private String addressLine2;

    private String addressLine3;

    private String location;

    private double latitude;

    private double longitude;

    @JsonIgnore
    public PhoneNumber getPhoneNumberObj() {
        return PhoneNumber.of(this.phoneNumber);
    }

    @JsonIgnore
    public Location getLocationObj() {
        return new Location(this.location, this.latitude, this.longitude);
    }

    @JsonIgnore
    public Address getAddressObj() {
        return new Address(this.city, this.country, this.addressLine1, this.addressLine2, this.addressLine3);
    }
}
