package zw.co.rubiem.netone.portal.faq;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Data
public class FrequentlyAskedRequest {
    @NotBlank(message = "Question is required!")
    private String question;

    @Lob
    @NotBlank(message = "Answer Is required!")
    private String answer;
}
