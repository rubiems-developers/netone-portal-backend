package zw.co.rubiem.netone.portal.service.boardmember;

import lombok.Data;

import javax.persistence.Lob;


@Data
public class BoardMemberDto {
    private Long id;
    private String title;

    private String firstName;

    private String lastName;
    @Lob
    private String profileDescription;

    private String imageUrl;

}
