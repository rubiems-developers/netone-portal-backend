package zw.co.rubiem.netone.portal.domain.promotions.competition;

import zw.co.rubiem.netone.portal.domain.commons.Price;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class CompetitionPrice extends BaseEntity {

    @NotBlank(message = "Competition Price title is required")
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 100)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "competition_price_level", nullable = false)
    private CompetitionPriceLevel competitionPriceLevel;

    @Embedded
    private Price price;

    private Integer totalPrices;

    public CompetitionPrice() {
    }

    public CompetitionPrice(CompetitionPriceLevel competitionPriceLevel) {
        this.totalPrices = (competitionPriceLevel.isFlat()) ? null : 3;
    }

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

    public CompetitionPriceLevel getCompetitionPriceLevel() {
        return competitionPriceLevel;
    }

    public void setCompetitionPriceLevel(CompetitionPriceLevel competitionPriceLevel) {
        this.competitionPriceLevel = competitionPriceLevel;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Integer getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(Integer totalPrices) {
        this.totalPrices = totalPrices;
    }
}
