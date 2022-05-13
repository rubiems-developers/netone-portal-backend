package zw.co.rubiem.netone.portal.domain.promotions.competition;

import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CompetitionCompetitionPrice extends BaseEntity {

    @NotNull(message = "Competition is required")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_ccp_competition"))
    private Competition competition;

    @NotNull(message = "CompetitionPrice is required")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "Fk_ccp_competition_price"))
    private CompetitionPrice competitionPrice;

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public CompetitionPrice getCompetitionPrice() {
        return competitionPrice;
    }

    public void setCompetitionPrice(CompetitionPrice competitionPrice) {
        this.competitionPrice = competitionPrice;
    }
}
