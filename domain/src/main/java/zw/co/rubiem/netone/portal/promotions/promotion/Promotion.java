package zw.co.rubiem.netone.portal.promotions.promotion;

import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Promotion extends BaseEntity {

    @NotBlank(message = "Promotion title is required")
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    private String imageUrl;

    @NotNull(message = "StartDate is required")
    @Column(nullable = false)
    private LocalDateTime startDate;

    @NotNull(message = "EndDate is required")
    @Column(nullable = false)
    private LocalDateTime endDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
