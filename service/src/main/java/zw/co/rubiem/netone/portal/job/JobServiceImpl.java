package zw.co.rubiem.netone.portal.job;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;
import zw.co.rubiem.netone.portal.jobs.JobDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class JobServiceImpl extends BaseServiceImpl<Job, JobRequest, JobUpdateRequest> implements JobService {
    private final JobDao jobDao;
    private final JobMapper jobMapper;

    public JobServiceImpl(JobDao jobDao, JobMapper jobMapper) {
        super(jobDao);
        this.jobDao = jobDao;
        this.jobMapper = jobMapper;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Job create(JobRequest createDto) {
        Optional<Job> optionalJob = jobDao.findByTitleIgnoreCase(createDto.getTitle());
        if (optionalJob.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        Job job = jobMapper
                .jobFromJobRequest(createDto);
        return jobDao.save(job);
    }

    @Override
    public Job update(JobUpdateRequest updateDto) {
        Job jobRecord = findById(updateDto.getId());
        Job job = jobMapper
                .jobFromJobUpdateRequest(jobRecord, updateDto);
        return jobDao.save(job);
    }

    @Override
    public Collection<Job> findAll() {
        return null;
    }

    @Override
    protected Class<Job> getEntityClass() {
        return Job.class;
    }

    @Override
    public Job findByName(String name) {
        return jobDao.findByTitleIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public JobDto findJobById(Long id) {
        return jobMapper.jobDtoFromJob(findById(id));
    }

    @Override
    public Page<JobDto> findAllJobs(Pageable pageable, String searchQuery) {
        Page<Job> jobPage = findAll(pageable, searchQuery);
        return jobPage
                .map(job -> {
                    JobDto dto = new JobDto();
                    dto.setId(job.getId());
                    dto.setTitle(job.getTitle());
                    dto.setLocation(job.getLocation());
                    dto.setSpecification(job.getSpecification());
                    dto.setRequirements(job.getRequirements());
                    dto.setPublishedDate(job.getPublishedDate());
                    dto.setClosingDate(job.getClosingDate());
                    return dto;
                });
    }

    @Override
    public Collection<JobDto> findAllJobs() {
        Collection<Job> jobs = findAll();
        Collection<JobDto> jobDtos = new ArrayList<>();
        jobs.forEach(job ->
                jobDtos.add(jobMapper.jobDtoFromJob(job)));
        return jobDtos;
    }
}
