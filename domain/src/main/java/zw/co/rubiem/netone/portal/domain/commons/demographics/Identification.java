package zw.co.rubiem.netone.portal.domain.commons.demographics;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Identification {

    @Enumerated(EnumType.STRING)
    @Column(name = "identification_type", nullable = false)
    private IdentificationType identificationType;

    @Column(nullable = false, length = 50, unique = true)
    private String value;

    public Identification() {

    }

    public Identification(IdentificationType identificationType, String value) {
        this.identificationType = identificationType;
        this.value = value;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
