package zw.co.rubiem.netone.portal.faq;

public interface FrequentlyAskedMapper {
    FrequentlyAskedDto frequentlyAskedDtoFromFrequentlyAsked(FrequentlyAsked frequentlyAsked);

    FrequentlyAsked frequentlyAskedFromFrequentlyAskedRequest(FrequentlyAskedRequest frequentlyAskedRequest);

    FrequentlyAsked frequentlyAskedFromFrequentlyAskedUpdateRequest(FrequentlyAsked frequentlyAsked, FrequentlyAskedUpdateRequest frequentlyAskedUpdateRequest);
}
