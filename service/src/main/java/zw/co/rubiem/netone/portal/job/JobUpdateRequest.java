package zw.co.rubiem.netone.portal.job;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class JobUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Title is required!")
    private String title;
    @NotBlank(message = "Location is required!")
    private String location;
    @NotBlank(message = "Specification is required!")
    private String specification;
    @NotBlank(message = "Requirements is required!")
    private String requirements;
    @NotBlank(message = "Opening date is required!")
    private LocalDate publishedDate;
    @NotBlank(message = "Closing date is required!")
    private LocalDate closingDate;
}
