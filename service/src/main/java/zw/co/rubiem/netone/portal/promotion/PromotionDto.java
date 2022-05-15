package zw.co.rubiem.netone.portal.promotion;

import lombok.Data;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@Data
public class PromotionDto {
    private Long id;
    private String title;
    @Lob
    private String description;

    private String imageUrl;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
