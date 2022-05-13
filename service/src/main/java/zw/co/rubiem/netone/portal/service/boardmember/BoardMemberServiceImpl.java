package zw.co.rubiem.netone.portal.service.boardmember;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.dao.boardmember.BoardMemberDao;
import zw.co.rubiem.netone.portal.domain.boardmember.BoardMember;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.ItemAlreadyExistsException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BoardMemberServiceImpl extends BaseServiceImpl<BoardMember, BoardMemberRequest, BoardMemberUpdateRequest> implements BoardMemberService {

    private final BoardMemberDao boardMemberDao;
    private final BoardMemberMapper boardMemberMapper;

    public BoardMemberServiceImpl(BoardMemberDao boardMemberDao, BoardMemberMapper boardMemberMapper) {
        super(boardMemberDao);
        this.boardMemberDao = boardMemberDao;
        this.boardMemberMapper = boardMemberMapper;
    }


    @Override
    protected Class<BoardMember> getEntityClass() {
        return BoardMember.class;
    }

    @Override
    public BoardMemberDto findBoardMemberById(Long id) {
        return boardMemberMapper.boardMemberDtoFromBoardMember(findById(id));
    }

    @Override
    public Page<BoardMemberDto> findAllBoardMembers(Pageable pageable, String searchQuery) {
        Page<BoardMember> boardMemberPage = findAll(pageable, searchQuery);
        return boardMemberPage
                .map(boardMember -> {
                    BoardMemberDto dto = new BoardMemberDto();
                    dto.setFirstName(boardMember.getFirstName());
                    dto.setLastName(boardMember.getLastName());
                    dto.setImageUrl(boardMember.getImageUrl());
                    dto.setTitle(boardMember.getTitle());
                    dto.setProfileDescription(boardMember.getProfileDescription());
                    return dto;
                });
    }

    @Override
    public Collection<BoardMemberDto> findAllBoardMembers() {
        Collection<BoardMember> boardMembers = findAll();
        Collection<BoardMemberDto> boardMemberDtos = new ArrayList<>();
        boardMembers.forEach(boardMember ->
                boardMemberDtos.add(boardMemberMapper.boardMemberDtoFromBoardMember(boardMember)));
        return boardMemberDtos;
    }

    @Override
    public BoardMemberDto updateBoardMember(BoardMemberUpdateRequest boardMemberUpdateRequest) {
        return null;
    }

    @Override
    public Page<BoardMember> findAll(java.awt.print.Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    @Transactional
    public BoardMember create(BoardMemberRequest createDto) {
        Optional<BoardMember> optionalBoardMember = boardMemberDao.findByTitleIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCase(createDto.getTitle(),createDto.getFirstName(),createDto.getLastName());
        if (optionalBoardMember.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        BoardMember boardMember = boardMemberMapper.boardMemberFromBoardMemberRequest(createDto);
        return boardMemberDao.save(boardMember);
    }

    @Override
    @Transactional
    public BoardMember update(BoardMemberUpdateRequest updateDto) {
        BoardMember boardMemberRecord = findById(updateDto.getId());
        BoardMember boardMember = boardMemberMapper
                .boardMemberFromBoardMemberUpdateRequest(boardMemberRecord, updateDto);
        return boardMemberDao.save(boardMember);
    }
}