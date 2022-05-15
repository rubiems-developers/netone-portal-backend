package zw.co.rubiem.netone.portal.tender;

public interface TenderMapper {
    Tender tenderFromTenderRequest(TenderRequest tenderRequest);
    Tender tenderFromTenderUpdateRequest(Tender tender, TenderUpdateRequest tenderUpdateRequest);
    TenderDto tenderDtoFromTender(Tender tender);
}
