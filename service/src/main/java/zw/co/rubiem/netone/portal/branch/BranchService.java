package zw.co.rubiem.netone.portal.branch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface BranchService extends BaseService<Branch, BranchRequest, BranchUpdateRequest> {

   Branch findByName(String name);

    BranchDto findBranchById(Long id);

    Page<BranchDto> findAllBranches(Pageable pageable, String searchQuery);

    Collection<BranchDto> findAllBranches();

}
