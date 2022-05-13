package zw.co.rubiem.netone.portal.api.faq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.domain.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.service.faq.*;


import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "Frequently Asked Questions")
@RequestMapping("v1/frequently_asked")
public class FrequentlyAskedController {
    private final FrequentlyAskedService frequentlyAskedService;

    private final FrequentlyAskedMapper frequentlyAskedMapper;

    public FrequentlyAskedController(FrequentlyAskedService frequentlyAskedService, FrequentlyAskedMapper frequentlyAskedMapper) {
        this.frequentlyAskedService = frequentlyAskedService;
        this.frequentlyAskedMapper = frequentlyAskedMapper;
    }

    @GetMapping("")
    @ApiOperation("Get FrequentlyAsked")
    public Page<FrequentlyAskedDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                           @RequestParam(required = false) String search) {
        return frequentlyAskedService.findAllFrequentlyAsked(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All FrequentlyAsked")
    public Collection<FrequentlyAskedDto> getAll() {
        return frequentlyAskedService.findAllFrequentlyAskedCollection();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a FrequentlyAsked by Id")
    public FrequentlyAskedDto getFrequentlyAsked(@PathVariable long id) {
        return frequentlyAskedService.findFrequentlyAskedById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a FrequentlyAsked by Id")
    public void delete(@PathVariable long id) {
        frequentlyAskedService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create a FrequentlyAsked")
    public FrequentlyAskedDto create(@RequestBody FrequentlyAskedRequest request) {
        return frequentlyAskedMapper.frequentlyAskedDtoFromFrequentlyAsked(frequentlyAskedService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update FrequentlyAsked")
    public FrequentlyAskedDto update(@RequestBody FrequentlyAskedUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Job not found!");
        }
        return frequentlyAskedMapper.frequentlyAskedDtoFromFrequentlyAsked(frequentlyAskedService.update(request));
    }
}
