package zw.co.rubiem.netone.portal.api.branch;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.branch.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "Branches")
@RequestMapping("v1/branch")
public class BranchController {

    private final BranchService branchService;

    private final BranchMapper branchMapper;

    public BranchController(BranchService branchService, BranchMapper branchMapper) {
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    @GetMapping("")
    @ApiOperation("Get Branches")
    public Page<BranchDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                  @RequestParam(required = false) String search) {
        return branchService.findAllBranches(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All Branches")
    public Collection<BranchDto> getAll() {
        return branchService.findAllBranches();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a Branch by Id")
    public BranchDto getBranch(@PathVariable long id) {
        return branchService.findBranchById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Branch by Id")
    public void delete(@PathVariable long id) {
        branchService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create Branch")
    public BranchDto create(@RequestBody BranchRequest request) {
        return branchMapper.branchDtoFromBranch(branchService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Branch")
    public BranchDto update(@RequestBody BranchUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return branchMapper.branchDtoFromBranch(branchService.update(request));
    }

}