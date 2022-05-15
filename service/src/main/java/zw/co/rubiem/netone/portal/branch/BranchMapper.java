package zw.co.rubiem.netone.portal.branch;

public interface BranchMapper {

    BranchDto branchDtoFromBranch(Branch branch);

    Branch branchFromBranchRequest(BranchRequest branchRequest);

    Branch branchFromBranchUpdateRequest(Branch branchRecord, BranchUpdateRequest branchUpdateRequest);

}
