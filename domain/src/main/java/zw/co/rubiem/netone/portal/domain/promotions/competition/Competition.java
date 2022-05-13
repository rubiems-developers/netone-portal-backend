package zw.co.rubiem.netone.portal.domain.promotions.competition;

import zw.co.rubiem.netone.portal.domain.commons.Price;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Competition extends BaseEntity {

    @NotBlank(message = "Competition title is required")
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Price price;

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

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
