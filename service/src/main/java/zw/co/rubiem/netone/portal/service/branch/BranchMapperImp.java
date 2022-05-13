package zw.co.rubiem.netone.portal.service.branch;

import org.springframework.stereotype.Component;
import zw.co.rubiem.netone.portal.domain.branch.Branch;

import java.util.Objects;

@Component
public class BranchMapperImp implements BranchMapper {

    @Override
    public BranchDto branchDtoFromBranch(Branch branch) {
        Objects.requireNonNull(branch, "Branch must not be null");
        BranchDto branchDto = new BranchDto();
        branchDto.setId(branch.getId());
        branchDto.setName(branch.getName());
        branchDto.setLocation(branch.getLocation());
        branch.setAddress(branch.getAddress());
        return branchDto;
    }

    @Override
    public Branch branchFromBranchRequest(BranchRequest branchRequest) {
        Objects.requireNonNull(branchRequest, "BranchRequest must not be null");
        Branch branch = new Branch();
        branch.setName(branchRequest.getName());
        branch.setAddress(branchRequest.getAddressObj());
        branch.setLocation(branchRequest.getLocationObj());
        branch.setPhoneNumber(branchRequest.getPhoneNumberObj());
        return branch;
    }

    @Override
    public Branch branchFromBranchUpdateRequest(Branch branchRecord, BranchUpdateRequest branchUpdateRequest) {
        Objects.requireNonNull(branchRecord, "Branch must not be null");
        Objects.requireNonNull(branchUpdateRequest, "BranchUpdateRequest must not be null");
        branchRecord.setName(branchUpdateRequest.getName());
        branchRecord.setAddress(branchUpdateRequest.getAddress());
        branchRecord.setLocation(branchUpdateRequest.getLocation());
        branchRecord.setPhoneNumber(branchUpdateRequest.getPhoneNumber());
        return branchRecord;
    }

}
