package zw.co.rubiem.netone.portal.service.promotion;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PromotionRequest {

    private String title;

    @Lob
    private String description;

    private String imageUrl;

    @NotNull(message = "StartDate is required")
    private LocalDateTime startDate;

    @NotNull(message = "EndDate is required")
    private LocalDateTime endDate;

}
