package zw.co.rubiem.netone.portal.service.job;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class JobRequest {
    @NotBlank(message = "Title is required!")
    private String title;
    @NotBlank(message = "Location is required!")
    private String location;
    @NotBlank(message = "Specification is required!")
    private String specification;
    @NotBlank(message = "Requirements is required!")
    private String requirements;
    @NotBlank(message = "Published date is required!")
    private LocalDate publishedDate;
    @NotBlank(message = "Closing date is required!")
    private LocalDate closingDate;
}
