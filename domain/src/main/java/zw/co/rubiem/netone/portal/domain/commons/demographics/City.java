package zw.co.rubiem.netone.portal.domain.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class City {

    @NotBlank(message = "City Name Is Required!")
    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @NotBlank(message = "City Privince Is Required")
    @Column(name = "province", nullable = false, length = 100)
    private String province;

    @Column(name = "city_code", nullable = false, length = 10)
    private String cityCode;

    @Column(name = "city_abbreviation", nullable = false, length = 100)
    private String cityAbbreviation;

    public City() {
    }

    public City(String cityName, String province, String cityCode, String cityAbbreviation) {
        this.cityName = cityName;
        this.province = province;
        this.cityCode = cityCode;
        this.cityAbbreviation = cityAbbreviation;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityAbbreviation() {
        return cityAbbreviation;
    }

    public void setCityAbbreviation(String cityAbbreviation) {
        this.cityAbbreviation = cityAbbreviation;
    }
}
