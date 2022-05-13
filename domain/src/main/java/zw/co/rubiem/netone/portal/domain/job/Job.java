package zw.co.rubiem.netone.portal.domain.job;

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
public class Job  extends BaseEntity {

    @NotNull(message = "Job title cannot be empty")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Job location cannot be empty")
    @Column(nullable = false)
    @Size( max = 200)
    private String location;

    @Lob
    @NotBlank(message = "Job Specification cannot be empty")
    @Column(nullable = false)
    private String specification;


    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Job requirements cannot be empty")
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
