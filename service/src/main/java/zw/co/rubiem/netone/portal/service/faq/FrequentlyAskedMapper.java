package zw.co.rubiem.netone.portal.service.faq;
import zw.co.rubiem.netone.portal.domain.faq.FrequentlyAsked;

public interface FrequentlyAskedMapper {
    FrequentlyAskedDto frequentlyAskedDtoFromFrequentlyAsked(FrequentlyAsked frequentlyAsked);

    FrequentlyAsked frequentlyAskedFromFrequentlyAskedRequest(FrequentlyAskedRequest frequentlyAskedRequest);

    FrequentlyAsked frequentlyAskedFromFrequentlyAskedUpdateRequest(FrequentlyAsked frequentlyAsked, FrequentlyAskedUpdateRequest frequentlyAskedUpdateRequest);
}
