package zw.co.rubiem.netone.portal.boardmember;

public interface BoardMemberMapper {

    BoardMember boardMemberFromBoardMemberRequest(BoardMemberRequest boardMemberRequest);

    BoardMember boardMemberFromBoardMemberUpdateRequest(BoardMember boardMember, BoardMemberUpdateRequest boardMemberUpdateRequest);

    BoardMemberDto boardMemberDtoFromBoardMember(BoardMember boardMember);

}
