package zw.co.rubiem.netone.portal.job;

public interface JobMapper {
    Job jobFromJobRequest(JobRequest jobRequest);
    Job jobFromJobUpdateRequest(Job job, JobUpdateRequest jobUpdateRequest);
    JobDto jobDtoFromJob(Job job);
}
