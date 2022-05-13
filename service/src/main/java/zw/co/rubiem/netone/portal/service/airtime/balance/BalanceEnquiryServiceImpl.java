package zw.co.rubiem.netone.portal.service.airtime.balance;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.dao.airtime.BalanceEnquiryDao;
import zw.co.rubiem.netone.portal.domain.airtime.BalanceEnquiry;
import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseServiceImpl;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class BalanceEnquiryServiceImpl extends BaseServiceImpl<BalanceEnquiry, BalanceEnquiryRequest, BalanceEnquiryUpdateRequest> implements BalanceEnquiryService {

    private final BalanceEnquiryDao balanceEnquiryDao;
    private final BalanceEnquiryMapper balanceEnquiryMapper;
    public BalanceEnquiryServiceImpl(BalanceEnquiryDao balanceEnquiryDao, BalanceEnquiryMapper balanceEnquiryMapper) {
        super(balanceEnquiryDao);
        this.balanceEnquiryDao=balanceEnquiryDao;
        this.balanceEnquiryMapper=balanceEnquiryMapper;
    }

    @Override
    public Page<BalanceEnquiry> findAll(Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    public BalanceEnquiry create(BalanceEnquiryRequest createDto){
        BalanceEnquiry balanceEnquiry = balanceEnquiryMapper.balanceEnquiryFromBalanceEnquiryRequest(createDto);
        return balanceEnquiryDao.save(balanceEnquiry);
    }

    @Override
    public BalanceEnquiry update(BalanceEnquiryUpdateRequest updateDto) {
        return null;
    }

    @Override
    protected Class<BalanceEnquiry> getEntityClass() {
        return null;
    }

    @Override
    public BalanceEnquiryDto findBalanceEnquiryById(Long id) {
        return balanceEnquiryMapper.balanceEnquiryDtoFromBalanceEnquiry(findById(id));
    }

    /*@Override
    public BalanceEnquiryDto balanceEnquiryWithPhoneNumber(String phoneNumber) {
        return balanceEnquiryMapper.balanceDtoFromBalanceEnquiry(findString(phoneNumber));
    }*/

    @Override
    public Page<BalanceEnquiryDto> findAllBalanceEnquiries(org.springframework.data.domain.Pageable pageable, String searchQuery) {
        Page<BalanceEnquiry> balanceEnquiryPage = findAll(pageable, searchQuery);
        return balanceEnquiryPage
                .map(balanceEnquiry -> {
                    BalanceEnquiryDto dto = new BalanceEnquiryDto();
                    dto.setPhoneNumber(balanceEnquiry.getPhoneNumber());
                    return dto;
                });
    }

    @Override
    public Collection<BalanceEnquiryDto> findAllBalanceEnquiries() {
        Collection<BalanceEnquiry> balanceEnquiries = findAll();
        Collection<BalanceEnquiryDto> balanceEnquiryDtos = new ArrayList<>();
        balanceEnquiries.forEach(balanceEnquiry ->
                balanceEnquiryDtos.add(balanceEnquiryMapper.balanceEnquiryDtoFromBalanceEnquiry(balanceEnquiry)));
        return balanceEnquiryDtos;
    }
}
