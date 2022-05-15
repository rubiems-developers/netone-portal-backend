package zw.co.rubiem.netone.portal.faq;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FrequentlyAskedMapperImpl implements FrequentlyAskedMapper {
    @Override
    public FrequentlyAskedDto frequentlyAskedDtoFromFrequentlyAsked(FrequentlyAsked frequentlyAsked) {
        Objects.requireNonNull(frequentlyAsked, "FrequentlyAsked must not be null");
        FrequentlyAskedDto frequentlyAskedDto = new FrequentlyAskedDto();
        frequentlyAskedDto.setId(frequentlyAsked.getId());
        frequentlyAskedDto.setQuestion(frequentlyAsked.getQuestion());
        frequentlyAskedDto.setAnswer(frequentlyAsked.getAnswer());
        return frequentlyAskedDto;
    }

    @Override
    public FrequentlyAsked frequentlyAskedFromFrequentlyAskedRequest(FrequentlyAskedRequest frequentlyAskedRequest) {
        Objects.requireNonNull(frequentlyAskedRequest, "FrequentlyAskedRequest must not be null");
        FrequentlyAsked frequentlyAsked = new FrequentlyAsked();
        frequentlyAsked.setQuestion(frequentlyAskedRequest.getQuestion());
        frequentlyAsked.setAnswer(frequentlyAskedRequest.getAnswer());

        return frequentlyAsked;
    }

    @Override
    public FrequentlyAsked frequentlyAskedFromFrequentlyAskedUpdateRequest(FrequentlyAsked frequentlyAskedRecord, FrequentlyAskedUpdateRequest frequentlyAskedUpdateRequest) {
        Objects.requireNonNull(frequentlyAskedRecord, "FrequentlyAsked must not be null");
        Objects.requireNonNull(frequentlyAskedUpdateRequest, "FrequentlyAskedUpdateRequest must not be null");
        frequentlyAskedRecord.setQuestion(frequentlyAskedUpdateRequest.getQuestion());
        frequentlyAskedRecord.setAnswer(frequentlyAskedUpdateRequest.getAnswer());
        return frequentlyAskedRecord;
    }
}
