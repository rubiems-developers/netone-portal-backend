package zw.co.rubiem.netone.portal.domain.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class PersonalDetails {

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "middle_names", length = 100)
    private String middleNames;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Embedded
    private Identification identification;

    public PersonalDetails() {
    }

    public PersonalDetails(String firstname, String middlenames, String lastname, Identification identification) {
        this.firstName = firstname;
        this.middleNames = middlenames;
        this.lastName = lastname;
        this.identification = identification;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getMiddlenames() {
        return middleNames;
    }

    public void setMiddlenames(String middlenames) {
        this.middleNames = middlenames;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

}
