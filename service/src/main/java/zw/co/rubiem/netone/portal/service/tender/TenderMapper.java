package zw.co.rubiem.netone.portal.service.tender;

import zw.co.rubiem.netone.portal.domain.tender.Tender;

public interface TenderMapper {
    Tender tenderFromTenderRequest(TenderRequest tenderRequest);
    Tender tenderFromTenderUpdateRequest(Tender tender, TenderUpdateRequest tenderUpdateRequest);
    TenderDto tenderDtoFromTender(Tender tender);
}
