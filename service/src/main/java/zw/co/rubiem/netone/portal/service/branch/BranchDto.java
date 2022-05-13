package zw.co.rubiem.netone.portal.service.branch;

import lombok.Data;
import zw.co.rubiem.netone.portal.domain.commons.demographics.Location;
import zw.co.rubiem.netone.portal.domain.commons.demographics.PhoneNumber;
import zw.co.rubiem.netone.portal.domain.commons.demographics.Address;

@Data
public class BranchDto {

    private Long id;

    private String name;

    private PhoneNumber phoneNumber;

    private Address address;

    private Location location;

}
