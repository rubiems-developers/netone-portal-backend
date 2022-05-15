package zw.co.rubiem.netone.portal.tender;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TenderUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Title is required!")

    private String tenderTitle;
    @NotBlank(message = "Location is required!")

    private String location;
    @NotBlank(message = "TenderNumber is required!")

    private String tenderNumber;
    @NotBlank(message = "Published Date is required!")

    private LocalDate publishedDate;
    @NotBlank(message = "Closing is required!")

    private LocalDate closingDate;
    @NotBlank(message = "Description is required!")

    private String tenderDescription;
}
