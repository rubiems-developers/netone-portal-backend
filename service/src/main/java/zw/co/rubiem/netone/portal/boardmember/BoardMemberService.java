package zw.co.rubiem.netone.portal.boardmember;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface BoardMemberService extends BaseService<BoardMember, BoardMemberRequest, BoardMemberUpdateRequest> {

    BoardMemberDto findBoardMemberById(Long id);

    Page<BoardMemberDto> findAllBoardMembers(Pageable pageable, String searchQuery);

    Collection<BoardMemberDto> findAllBoardMembers();

    BoardMemberDto updateBoardMember(BoardMemberUpdateRequest boardMemberUpdateRequest);

}
