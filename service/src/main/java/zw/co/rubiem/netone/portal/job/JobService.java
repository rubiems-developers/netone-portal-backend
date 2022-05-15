package zw.co.rubiem.netone.portal.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;

import java.util.Collection;

public interface JobService extends BaseService<Job, JobRequest, JobUpdateRequest> {
    Job findByName(String name);

    JobDto findJobById(Long id);

    Page<JobDto> findAllJobs(Pageable pageable, String searchQuery);

    Collection<JobDto> findAllJobs();
}
