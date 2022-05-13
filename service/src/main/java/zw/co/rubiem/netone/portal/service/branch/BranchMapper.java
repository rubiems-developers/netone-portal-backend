package zw.co.rubiem.netone.portal.service.branch;

import zw.co.rubiem.netone.portal.domain.branch.Branch;

public interface BranchMapper {

    BranchDto branchDtoFromBranch(Branch branch);

    Branch branchFromBranchRequest(BranchRequest branchRequest);

    Branch branchFromBranchUpdateRequest(Branch branchRecord, BranchUpdateRequest branchUpdateRequest);

}
