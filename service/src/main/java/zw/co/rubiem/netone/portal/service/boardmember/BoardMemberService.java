package zw.co.rubiem.netone.portal.service.boardmember;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.boardmember.BoardMember;

import java.util.Collection;

public interface BoardMemberService extends BaseService<BoardMember, BoardMemberRequest, BoardMemberUpdateRequest> {

    BoardMemberDto findBoardMemberById(Long id);

    Page<BoardMemberDto> findAllBoardMembers(Pageable pageable, String searchQuery);

    Collection<BoardMemberDto> findAllBoardMembers();

    BoardMemberDto updateBoardMember(BoardMemberUpdateRequest boardMemberUpdateRequest);

}
