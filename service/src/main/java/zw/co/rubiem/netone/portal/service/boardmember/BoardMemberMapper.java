package zw.co.rubiem.netone.portal.service.boardmember;

import zw.co.rubiem.netone.portal.domain.boardmember.BoardMember;

public interface BoardMemberMapper {

    BoardMember boardMemberFromBoardMemberRequest(BoardMemberRequest boardMemberRequest);

    BoardMember boardMemberFromBoardMemberUpdateRequest(BoardMember boardMember, BoardMemberUpdateRequest boardMemberUpdateRequest);

    BoardMemberDto boardMemberDtoFromBoardMember(BoardMember boardMember);

}
