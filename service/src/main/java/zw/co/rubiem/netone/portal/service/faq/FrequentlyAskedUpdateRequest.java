package zw.co.rubiem.netone.portal.service.faq;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class FrequentlyAskedUpdateRequest {
    @NotNull(message = "Id is required")
    private Long id;
    @NotBlank(message = "Question is required!")
    private String question;

    @Lob
    @NotBlank(message = "Answer Is required!")
    private String answer;

}
