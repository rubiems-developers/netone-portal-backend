package zw.co.rubiem.netone.portal.domain.boardmember;

import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "board_member")
public class BoardMember extends BaseEntity {

    @NotBlank(message = "BoardMember title is required")
    @Column(unique = true, nullable = false)
    @Size(max = 10)
    private String title;

    @NotBlank(message = "BoardMember First name is required")
    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String firstName;

    @NotBlank(message = "BoardMember Last name is required")
    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String lastName;

    @Lob
    @NotBlank(message = "BoardMember profile is required")
    private String profileDescription;

    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
