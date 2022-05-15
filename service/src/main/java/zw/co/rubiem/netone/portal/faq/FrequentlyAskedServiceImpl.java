package zw.co.rubiem.netone.portal.faq;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemAlreadyExistsException;
import zw.co.rubiem.netone.portal.commons.exceptions.ItemNotFoundException;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;


import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class FrequentlyAskedServiceImpl extends BaseServiceImpl<FrequentlyAsked, FrequentlyAskedRequest, FrequentlyAskedUpdateRequest> implements FrequentlyAskedService {
    private final FrequentlyAskedDao frequentlyAskedDao;
    private final FrequentlyAskedMapper frequentlyAskedMapper;

    public FrequentlyAskedServiceImpl(FrequentlyAskedDao frequentlyAskedDao ,FrequentlyAskedMapper frequentlyAskedMapper) {
        super(frequentlyAskedDao);
        this.frequentlyAskedDao = frequentlyAskedDao;
        this.frequentlyAskedMapper = frequentlyAskedMapper;
    }

    @Override
    public Page<FrequentlyAsked> findAll(Pageable pageable, String searchQuery) {
        Page<FrequentlyAsked> frequentlyAskedPage = findAll(pageable, searchQuery);
        return frequentlyAskedPage
                .map(frequentlyAsked -> {
                    FrequentlyAsked frequentlyAsked1 = new FrequentlyAsked();
                    frequentlyAsked1.setId(frequentlyAsked.getId());
                    frequentlyAsked1.setQuestion(frequentlyAsked.getQuestion());
                    frequentlyAsked1.setAnswer(frequentlyAsked.getAnswer());
                    return frequentlyAsked1;
                });
    }

    @Override
    public FrequentlyAsked create(FrequentlyAskedRequest createDto) {
        Optional<FrequentlyAsked> optionalFrequentlyAsked = frequentlyAskedDao.findByQuestionIgnoreCase(createDto.getQuestion());
        if (optionalFrequentlyAsked.isPresent()) {
            throw new ItemAlreadyExistsException(getEntityClass().getSimpleName());
        }
        FrequentlyAsked frequentlyAsked = frequentlyAskedMapper
                .frequentlyAskedFromFrequentlyAskedRequest(createDto);
        return frequentlyAskedDao.save(frequentlyAsked);
    }

    @Override
    public FrequentlyAsked update(FrequentlyAskedUpdateRequest updateDto) {
        FrequentlyAsked frequentlyAskedRecord = findById(updateDto.getId());
        FrequentlyAsked frequentlyAsked = frequentlyAskedMapper
                .frequentlyAskedFromFrequentlyAskedUpdateRequest(frequentlyAskedRecord, updateDto);
        return frequentlyAskedDao.save(frequentlyAsked);
    }

    @Override
    protected Class<FrequentlyAsked> getEntityClass() {
        return FrequentlyAsked.class;
    }

    @Override
    public FrequentlyAsked findByQuestion(String question) {
        return frequentlyAskedDao.findByQuestionIgnoreCase(question).
                orElseThrow(() -> new ItemNotFoundException(getEntityClass().getSimpleName()));
    }

    @Override
    public FrequentlyAskedDto findFrequentlyAskedById(Long id) {
        return frequentlyAskedMapper.frequentlyAskedDtoFromFrequentlyAsked(findById(id));
    }

    @Override
    public Page<FrequentlyAskedDto> findAllFrequentlyAsked(org.springframework.data.domain.Pageable pageable, String searchQuery) {
        Page<FrequentlyAsked> frequentlyAskedPage = findAll(pageable, searchQuery);
        return frequentlyAskedPage
                .map(frequentlyAsked -> {
                    FrequentlyAskedDto dto = new FrequentlyAskedDto();
                    dto.setId(frequentlyAsked.getId());
                    dto.setQuestion(frequentlyAsked.getQuestion());
                    dto.setAnswer(frequentlyAsked.getAnswer());
                    return dto;
                });
    }

    @Override
    public Collection<FrequentlyAskedDto> findAllFrequentlyAskedCollection() {
        Collection<FrequentlyAsked> frequentlyAskeds = findAll();
        Collection<FrequentlyAskedDto> frequentlyAskedDtos = new ArrayList<>();
        frequentlyAskeds.forEach(job ->
                frequentlyAskedDtos.add(frequentlyAskedMapper.frequentlyAskedDtoFromFrequentlyAsked(job)));
        return frequentlyAskedDtos;
    }
}
