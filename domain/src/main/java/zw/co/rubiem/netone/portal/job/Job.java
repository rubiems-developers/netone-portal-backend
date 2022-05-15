package zw.co.rubiem.netone.portal.job;

import io.swagger.annotations.ApiModelProperty;
import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Job  extends BaseEntity {

    @NotNull(message = "Job title is required")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Job location is required")
    @Column(nullable = false)
    @Size( max = 200)
    private String location;

    @Lob
    @NotBlank(message = "Job Specification is required")
    @Column(nullable = false)
    private String specification;


    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Job requirements is required")
    private String requirements;

    @NotNull
    @ApiModelProperty(required = true,example = "2016-01-01")
    private LocalDate publishedDate;

    @NotNull
    @ApiModelProperty(required = true,example = "2016-01-01")
    private LocalDate closingDate;


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
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
}
