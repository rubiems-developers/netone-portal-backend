package zw.co.rubiem.netone.portal.faq;

import zw.co.rubiem.netone.portal.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Entity
public class FrequentlyAsked extends BaseEntity {

    @Column(nullable = false, length = 200)
    @NotBlank(message = "Question is required!")
    private String question;

    @Lob
    @NotBlank(message = "Answer is required")
    @Column(nullable = false)
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
