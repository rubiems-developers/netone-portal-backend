package zw.co.rubiem.netone.portal.tender;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TenderMapperImpl implements TenderMapper {
    @Override
    public Tender tenderFromTenderRequest(TenderRequest tenderRequest) {
        Objects.requireNonNull(tenderRequest, "TenderRequest must not be null");
        Tender tender = new Tender();
        tender.setTenderTitle(tenderRequest.getTenderTitle());
        tender.setLocation(tenderRequest.getLocation());
        tender.setTenderNumber(tenderRequest.getTenderNumber());
        tender.setPublishedDate(tenderRequest.getPublishedDate());
        tender.setClosingDate(tenderRequest.getClosingDate());
        tender.setTenderDescription(tenderRequest.getTenderDescription());
        return tender;
    }

    @Override
    public Tender tenderFromTenderUpdateRequest(Tender tender, TenderUpdateRequest tenderUpdateRequest) {
        Objects.requireNonNull(tender, "Tender must not be null");
        Objects.requireNonNull(tenderUpdateRequest, "TenderUpdateRequest must not be null");
        tender.setTenderTitle(tenderUpdateRequest.getTenderTitle());
        tender.setLocation(tenderUpdateRequest.getLocation());
        tender.setTenderNumber(tenderUpdateRequest.getTenderNumber());
        tender.setTenderDescription(tenderUpdateRequest.getTenderDescription());
        tender.setPublishedDate(tenderUpdateRequest.getPublishedDate());
        tender.setClosingDate(tenderUpdateRequest.getClosingDate());
        return tender;
    }

    @Override
    public TenderDto tenderDtoFromTender(Tender tender) {
        Objects.requireNonNull(tender, "Tender must not be null");
        TenderDto tenderDto = new TenderDto();
        tenderDto.setTenderTitle(tender.getTenderTitle());
        tenderDto.setLocation(tender.getLocation());
        tenderDto.setTenderNumber(tender.getTenderNumber());
        tenderDto.setTenderDescription(tender.getTenderDescription());
        tenderDto.setPublishedDate(tender.getPublishedDate());
        tenderDto.setClosingDate(tender.getClosingDate());
        return tenderDto;
    }
}
