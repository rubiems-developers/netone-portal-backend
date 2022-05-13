package zw.co.rubiem.netone.portal.domain.tender;

import io.swagger.annotations.ApiModelProperty;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Tender extends BaseEntity {
    @NotNull(message = "Tender title cannot be empty")
    @Column(nullable = false)
    private String tenderTitle;

    @NotBlank(message = "Tender location cannot be empty")
    @Column(nullable = false)
    @Size( max = 200)
    private String location;

    @NotNull(message = "Tender number cannot be empty")
    @Column(nullable = false)
    private String tenderNumber;

    @NotNull
    @ApiModelProperty(required = true,example = "2016-01-01")
    private LocalDate publishedDate;

    @NotNull
    @ApiModelProperty(required = true,example = "2016-01-01")
    private LocalDate closingDate;

    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Tender description cannot be empty")
    private String tenderDescription;

    public String getTenderTitle() {
        return tenderTitle;
    }

    public void setTenderTitle(String tenderTitle) {
        this.tenderTitle = tenderTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTenderNumber() {
        return tenderNumber;
    }

    public void setTenderNumber(String tenderNumber) {
        this.tenderNumber = tenderNumber;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public String getTenderDescription() {
        return tenderDescription;
    }

    public void setTenderDescription(String tenderDescription) {
        this.tenderDescription = tenderDescription;
    }
}
