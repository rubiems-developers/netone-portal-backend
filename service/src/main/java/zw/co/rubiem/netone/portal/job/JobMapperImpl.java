package zw.co.rubiem.netone.portal.job;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class JobMapperImpl implements JobMapper{

    @Override
    public Job jobFromJobRequest(JobRequest jobRequest) {
        Objects.requireNonNull(jobRequest, "JobRequest must not be null");
        Job job = new Job();
        job.setTitle(jobRequest.getTitle());
        job.setLocation(jobRequest.getLocation());
        job.setSpecification(jobRequest.getSpecification());
        job.setRequirements(jobRequest.getRequirements());
        job.setPublishedDate(jobRequest.getPublishedDate());
        job.setClosingDate(jobRequest.getClosingDate());
        return job;
    }

    @Override
    public Job jobFromJobUpdateRequest(Job job, JobUpdateRequest jobUpdateRequest) {
        Objects.requireNonNull(job, "Job must not be null");
        Objects.requireNonNull(jobUpdateRequest, "JobUpdateRequest must not be null");
        job.setTitle(jobUpdateRequest.getTitle());
        job.setLocation(jobUpdateRequest.getLocation());
        job.setSpecification(jobUpdateRequest.getSpecification());
        job.setRequirements(jobUpdateRequest.getRequirements());
        job.setPublishedDate(jobUpdateRequest.getPublishedDate());
        job.setClosingDate(jobUpdateRequest.getClosingDate());
        return job;
    }

    @Override
    public JobDto jobDtoFromJob(Job job) {
        Objects.requireNonNull(job, "Job must not be null");
        JobDto jobDto = new JobDto();
        jobDto.setTitle(job.getTitle());
        jobDto.setLocation(job.getLocation());
        jobDto.setSpecification(job.getSpecification());
        jobDto.setRequirements(job.getRequirements());
        jobDto.setPublishedDate(job.getPublishedDate());
        jobDto.setClosingDate(job.getClosingDate());
        return jobDto;
    }
}
