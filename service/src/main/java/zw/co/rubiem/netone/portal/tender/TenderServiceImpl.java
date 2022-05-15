package zw.co.rubiem.netone.portal.tender;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
@Service
public class TenderServiceImpl extends BaseServiceImpl<Tender, TenderRequest, TenderUpdateRequest> implements TenderService {
    private final TenderDao tenderDao;
    private final TenderMapper tenderMapper;
    public TenderServiceImpl(TenderDao tenderDao, TenderMapper tenderMapper) {
        super(tenderDao);
        this.tenderDao=tenderDao;
        this.tenderMapper=tenderMapper;
    }

    @Override
    public Page<Tender> findAll(Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    public Tender create(TenderRequest createDto) {
        Optional<Tender> optionalTender = tenderDao.findByTenderTitleIgnoreCase(createDto.getTenderTitle());
        if (optionalTender.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        Tender tender = tenderMapper
                .tenderFromTenderRequest(createDto);
        return tenderDao.save(tender);
    }

    @Override
    public Tender update(TenderUpdateRequest updateDto) {
        Tender tenderRecord = findById(updateDto.getId());
        Tender tender = tenderMapper
                .tenderFromTenderUpdateRequest(tenderRecord, updateDto);
        return tenderDao.save(tender);
    }

    @Override
    protected Class<Tender> getEntityClass() {
        return Tender.class;
    }

    @Override
    public Tender findByName(String name) {
        return tenderDao.findByTenderTitleIgnoreCase(name).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public TenderDto findTenderById(Long id) {
        return tenderMapper.tenderDtoFromTender(findById(id));
    }

    @Override
    public Page<TenderDto> findAllTenders(Pageable pageable, String searchQuery) {
        Page<Tender> tenderPage = findAll(pageable, searchQuery);
        return tenderPage
                .map(tender -> {
                    TenderDto dto = new TenderDto();
                    dto.setId(tender.getId());
                    dto.setTenderTitle(tender.getTenderTitle());
                    dto.setLocation(tender.getLocation());
                    dto.setTenderNumber(tender.getTenderNumber());
                    dto.setTenderDescription(tender.getTenderDescription());
                    dto.setPublishedDate(tender.getPublishedDate());
                    dto.setClosingDate(tender.getClosingDate());
                    return dto;
                });
    }

    @Override
    public Collection<TenderDto> findAllTenders() {
        Collection<Tender> tenders = findAll();
        Collection<TenderDto> tenderDtos = new ArrayList<>();
        tenders.forEach(tender ->
                tenderDtos.add(tenderMapper.tenderDtoFromTender(tender)));
        return tenderDtos;
    }
}
