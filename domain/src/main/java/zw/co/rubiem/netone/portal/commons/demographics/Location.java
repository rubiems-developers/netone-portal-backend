package zw.co.rubiem.netone.portal.commons.demographics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Column(name = "location_name", nullable = false, length = 100)
    private String name;

    @Column(name = "latitude", length = 100)
    private double latitude;

    @Column(name = "longitude", length = 100)
    private double longitude;

}
