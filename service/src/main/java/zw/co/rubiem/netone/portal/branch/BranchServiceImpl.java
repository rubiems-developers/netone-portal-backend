package zw.co.rubiem.netone.portal.branch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BranchServiceImpl extends BaseServiceImpl<Branch, BranchRequest, BranchUpdateRequest> implements BranchService {

    private final BranchDao branchDao;

    private final BranchMapper branchMapper;

    public BranchServiceImpl(BranchDao branchDao, BranchMapper branchMapper) {
        super(branchDao);
        this.branchDao = branchDao;
        this.branchMapper = branchMapper;
    }

    @Override
    protected Class<Branch> getEntityClass() {
        return Branch.class;
    }

    @Override
    public Page<Branch> findAll(Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    @Transactional
    public Branch create(BranchRequest createDto) {
        Optional<Branch> optionalBranch = branchDao.findByNameIgnoreCase(createDto.getName());
        if (optionalBranch.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        Branch branch = branchMapper.branchFromBranchRequest(createDto);

        return branchDao.save(branch);
    }

    @Override
    @Transactional
    public Branch update(BranchUpdateRequest updateDto) {
        Branch branchRecord = findById(updateDto.getId());
        Branch branch = branchMapper
                .branchFromBranchUpdateRequest(branchRecord, updateDto);
        return branchDao.save(branch);
    }

    @Override
    public Branch findByName(String name) {
        return branchDao.findByNameIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public BranchDto findBranchById(Long id) {
        return branchMapper.branchDtoFromBranch(findById(id));
    }

    @Override
    public Page<BranchDto> findAllBranches(Pageable pageable, String searchQuery) {
        Page<Branch> branchPage = findAll(pageable, searchQuery);
        return branchPage
                .map(branch -> {
                    BranchDto dto = new BranchDto();
                    dto.setId(branch.getId());
                    dto.setName(branch.getName());
                    dto.setLocation(branch.getLocation());
                    dto.setPhoneNumber(branch.getPhoneNumber());
                    dto.setAddress(branch.getAddress());
                    return dto;
                });
    }

    @Override
    public Collection<BranchDto> findAllBranches() {
        Collection<Branch> branchCategories = findAll();
        Collection<BranchDto> branchDtos = new ArrayList<>();
        branchCategories.forEach(branch ->
                branchDtos.add(branchMapper.branchDtoFromBranch(branch)));
        return branchDtos;
    }

}
