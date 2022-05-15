package zw.co.rubiem.netone.portal.api.promotion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import zw.co.rubiem.netone.portal.commons.exceptions.InvalidRequestException;
import zw.co.rubiem.netone.portal.promotion.*;

import java.util.Collection;

@CrossOrigin
@RestController
@Api(tags = "Promotions")
@RequestMapping("v1/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    private final PromotionMapper promotionMapper;

    public PromotionController(PromotionService promotionService, PromotionMapper promotionMapper) {
        this.promotionService = promotionService;
        this.promotionMapper = promotionMapper;
    }

    @GetMapping("")
    @ApiOperation("Get Promotions")
    public Page<PromotionDto> getAll(@PageableDefault(sort = "name") Pageable pageable,
                                     @RequestParam(required = false) String search) {
        return promotionService.findAllPromotions(pageable, search);
    }

    @GetMapping("/all")
    @ApiOperation("Get All Promotions")
    public Collection<PromotionDto> getAll() {
        return promotionService.findAllPromotions();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a Promotion by Id")
    public PromotionDto getPromotion(@PathVariable long id) {
        return promotionService.findPromotionById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete a Promotion by Id")
    public void delete(@PathVariable long id) {
        promotionService.delete(id);
    }

    @PostMapping("")
    @ApiOperation("Create Promotion")
    public PromotionDto create(@RequestBody PromotionRequest request) {
        return promotionMapper.promotionDtoFromPromotion(promotionService.create(request));
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Promotion")
    public PromotionDto update(@RequestBody PromotionUpdateRequest request, @PathVariable long id) {
        if (request.getId() != id) {
            throw new InvalidRequestException("Record not found!");
        }
        return promotionMapper.promotionDtoFromPromotion(promotionService.update(request));
    }

}