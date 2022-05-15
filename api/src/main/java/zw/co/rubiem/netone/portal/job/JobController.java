package zw.co.rubiem.netone.portal.api.job;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.job.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "Jobs")
@RequestMapping("v1/jobs")
public class JobController {

    private final JobService jobService;

    private final JobMapper jobMapper;

    public JobController(JobService jobService, JobMapper jobMapper) {
        this.jobService = jobService;
        this.jobMapper = jobMapper;
    }


    @GetMapping("")
    @ApiOperation("Get Jobs")
    public Page<JobDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                               @RequestParam(required = false) String search) {
        return jobService.findAllJobs(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All Jobs")
    public Collection<JobDto> getAll() {
        return jobService.findAllJobs();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a Job by Id")
    public JobDto getProvider(@PathVariable long id) {
        return jobService.findJobById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Job by Id")
    public void delete(@PathVariable long id) {
        jobService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create a Job")
    public JobDto create(@RequestBody JobRequest request) {
        return jobMapper.jobDtoFromJob(jobService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Job")
    public JobDto update(@RequestBody JobUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Job not found!");
        }
        return jobMapper.jobDtoFromJob(jobService.update(request));
    }
}
