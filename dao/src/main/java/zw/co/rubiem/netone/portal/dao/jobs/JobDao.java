package zw.co.rubiem.netone.portal.dao.jobs;

import org.springframework.stereotype.Repository;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseDao;
import zw.co.rubiem.netone.portal.domain.job.Job;

import java.util.Optional;

@Repository
public interface JobDao extends BaseDao<Job> {
    Optional<Job> findByTitleIgnoreCase(String title);
}
