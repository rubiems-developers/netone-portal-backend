package zw.co.rubiem.netone.portal.job;

import lombok.Data;

import javax.persistence.Lob;
import java.time.LocalDate;

@Data
public class JobDto {
    private Long id;
    private String title;
    private String location;
    @Lob
    private String specification;
    @Lob
    private String requirements;
    private LocalDate publishedDate;
    private LocalDate closingDate;

}
