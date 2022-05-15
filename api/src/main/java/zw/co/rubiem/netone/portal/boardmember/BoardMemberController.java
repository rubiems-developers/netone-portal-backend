package zw.co.rubiem.netone.portal.boardmember;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "BoardMember")
@RequestMapping("v1/board-members")
public class BoardMemberController {

    private final BoardMemberService boardMemberService;

    private final BoardMemberMapper boardMemberMapper;

    public BoardMemberController(BoardMemberService boardMemberService, BoardMemberMapper boardMemberMapper) {
        this.boardMemberService = boardMemberService;
        this.boardMemberMapper = boardMemberMapper;
    }

    @GetMapping("")
    @ApiOperation("Get BoardMembers")
    public Page<BoardMemberDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                       @RequestParam(required = false) String search) {
        return boardMemberService.findAllBoardMembers(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All BoardMembers")
    public Collection<BoardMemberDto> getAll() {
        return boardMemberService.findAllBoardMembers();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a BoardMember by Id")
    public BoardMemberDto getBoardMember(@PathVariable long id) {
        return boardMemberService.findBoardMemberById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a BoardMember by Id")
    public void delete(@PathVariable long id) {
        boardMemberService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create BoardMember")
    public BoardMemberDto create(@RequestBody BoardMemberRequest request) {
        return boardMemberMapper.boardMemberDtoFromBoardMember(boardMemberService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update BoardMember")
    public BoardMemberDto update(@RequestBody BoardMemberUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return boardMemberMapper.boardMemberDtoFromBoardMember(boardMemberService.update(request));
    }

}
