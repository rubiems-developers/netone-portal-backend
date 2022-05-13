package zw.co.rubiem.netone.portal.domain.promotions.competition;

public enum CompetitionPriceLevel {

    FIRST_PRICE(false),
    SECOND_PRICE(false),
    THIRD_PRICE(false),
    OTHER(true);

    private final boolean isFlat;

    CompetitionPriceLevel(boolean isFlat) {
        this.isFlat = isFlat;
    }

    public boolean isFlat() {
        return isFlat;
    }

}
