package zw.co.rubiem.netone.portal.service.tender;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseService;
import zw.co.rubiem.netone.portal.domain.tender.Tender;

import java.util.Collection;

public interface TenderService extends BaseService<Tender, TenderRequest, TenderUpdateRequest> {
    Tender findByName(String name);

    TenderDto findTenderById(Long id);

    Page<TenderDto> findAllTenders(Pageable pageable, String searchQuery);

    Collection<TenderDto> findAllTenders();
}
