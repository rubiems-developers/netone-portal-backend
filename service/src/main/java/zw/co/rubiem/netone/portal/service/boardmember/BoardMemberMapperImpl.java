package zw.co.rubiem.netone.portal.service.boardmember;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.boardmember.BoardMember;

import java.util.Objects;

@Component
public class BoardMemberMapperImpl implements BoardMemberMapper {
    @Override
    public BoardMember boardMemberFromBoardMemberRequest(BoardMemberRequest boardMemberRequest) {
        Objects.requireNonNull(boardMemberRequest, "BoardMember must not be null");
        BoardMember boardMember = new BoardMember();
        boardMember.setFirstName(boardMemberRequest.getFirstName());
        boardMember.setLastName(boardMemberRequest.getLastName());
        boardMember.setImageUrl(boardMemberRequest.getImageUrl());
        boardMember.setProfileDescription(boardMemberRequest.getProfileDescription());
        return boardMember;


    }

    @Override
    public BoardMember boardMemberFromBoardMemberUpdateRequest(BoardMember boardMember, BoardMemberUpdateRequest boardMemberUpdateRequest) {
        Objects.requireNonNull(boardMember, "BoardMember must not be null");
        Objects.requireNonNull(boardMemberUpdateRequest, "BoardMemberUpdateRequest must not be null");
        boardMember.setFirstName(boardMemberUpdateRequest.getFirstName());
        boardMember.setLastName(boardMemberUpdateRequest.getLastName());
        boardMember.setImageUrl(boardMemberUpdateRequest.getImageUrl());
        boardMember.setProfileDescription(boardMemberUpdateRequest.getProfileDescription());
        return boardMember;
    }

    @Override
    public BoardMemberDto boardMemberDtoFromBoardMember(BoardMember boardMember) {
        Objects.requireNonNull(boardMember, "BoardMember must not be null");
        BoardMemberDto boardMemberDto = new BoardMemberDto();
        boardMemberDto.setId(boardMemberDto.getId());
        boardMemberDto.setFirstName(boardMember.getFirstName());
        boardMemberDto.setLastName(boardMember.getLastName());
        boardMemberDto.setImageUrl(boardMember.getImageUrl());
        boardMemberDto.setProfileDescription(boardMember.getProfileDescription());
        return boardMemberDto;
    }

}
