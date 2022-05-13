package zw.co.rubiem.netone.portal.service.job;
import zw.co.rubiem.netone.portal.domain.job.Job;

public interface JobMapper {
    Job jobFromJobRequest(JobRequest jobRequest);
    Job jobFromJobUpdateRequest(Job job, JobUpdateRequest jobUpdateRequest);
    JobDto jobDtoFromJob(Job job);
}
