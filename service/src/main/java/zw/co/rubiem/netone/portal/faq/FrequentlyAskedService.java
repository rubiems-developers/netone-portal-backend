package zw.co.rubiem.netone.portal.faq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import zw.co.rubiem.netone.portal.commons.jpa.BaseService;


import java.util.Collection;

public interface FrequentlyAskedService extends BaseService<FrequentlyAsked, FrequentlyAskedRequest, FrequentlyAskedUpdateRequest> {
    FrequentlyAsked findByQuestion(String question);

    FrequentlyAskedDto findFrequentlyAskedById(Long id);

    Page<FrequentlyAskedDto> findAllFrequentlyAsked(Pageable pageable, String searchQuery);

    Collection<FrequentlyAskedDto> findAllFrequentlyAskedCollection();
}
