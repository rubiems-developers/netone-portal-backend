package zw.co.rubiem.netone.portal.faq;

import lombok.Data;

import javax.persistence.Lob;

@Data
public class FrequentlyAskedDto {
    private Long id;
    private String question;
    @Lob
    private String answer;
}
