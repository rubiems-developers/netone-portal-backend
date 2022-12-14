package zw.co.rubiem.netone.portal.tender;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TenderDto {
    private Long id;
    private String tenderTitle;
    private String location;
    private String tenderNumber;
    private LocalDate publishedDate;
    private LocalDate closingDate;

    private String tenderDescription;

}
