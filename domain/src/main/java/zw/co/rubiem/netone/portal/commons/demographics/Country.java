package zw.co.rubiem.netone.portal.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Country {

    @NotBlank(message = "Country Name Is Require")
    @Column(name = "country_name", nullable = false, length = 100)
    private String countryName;

    @Column(name = "country_code", nullable = false, length = 10)
    private String countryCode;

    @Column(name = "counrty_abbreviation", nullable = false, length = 10)
    private String countryAbbreviation;

    public Country() {
    }

    public Country(String countryName, String countryCode, String countryAbbreviation) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.countryAbbreviation = countryAbbreviation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }
}
