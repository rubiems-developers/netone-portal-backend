package zw.co.rubiem.netone.portal.airtime.recharge;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import zw.co.rubiem.netone.portal.airtime.AirtimeRecharge;
import zw.co.rubiem.netone.portal.airtime.AirtimeRechargeDao;
import zw.co.rubiem.netone.portal.commons.jpa.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class AirtimeRechargeServiceImpl extends BaseServiceImpl<AirtimeRecharge, AirtimeRechargeRequest, AirtimeRechargeUpdateRequest> implements AirtimeRechargeService {
    private final AirtimeRechargeDao airtimeRechargeDao;
    private final AirtimeRechargeMapper airtimeRechargeMapper;

    public AirtimeRechargeServiceImpl(AirtimeRechargeDao airtimeRechargeDao, AirtimeRechargeMapper airtimeRechargeMapper) {
        super(airtimeRechargeDao);
        this.airtimeRechargeDao = airtimeRechargeDao;
        this.airtimeRechargeMapper = airtimeRechargeMapper;
    }

    @Override
    public Page<AirtimeRecharge> findAll(Pageable pageable, String searchQuery) {
        return null;
    }

    @Override
    public AirtimeRecharge create(AirtimeRechargeRequest createDto) {
        AirtimeRecharge airtimeRecharge = airtimeRechargeMapper.airtimeRechargeFromAirtimeRechargeRequest(createDto);
        return airtimeRechargeDao.save(airtimeRecharge);
    }

    @Override
    public AirtimeRecharge update(AirtimeRechargeUpdateRequest updateDto) {
        return null;
    }

    @Override
    protected Class<AirtimeRecharge> getEntityClass() {
        return null;
    }

    @Override
    public AirtimeRechargeDto findAirtimeRechargeById(Long id) {
        return null;
    }

    @Override
    public Page<AirtimeRechargeDto> findAirtimeRecharges(org.springframework.data.domain.Pageable pageable, String searchQuery) {
        Page<AirtimeRecharge> airtimeRechargePage = findAll(pageable, searchQuery);
        return airtimeRechargePage
                .map(airtimeRecharge -> {
                    AirtimeRechargeDto dto = new AirtimeRechargeDto();
                    dto.setRecipientNumber(airtimeRecharge.getRecipientNumber());
                    dto.setRechargeAmount(airtimeRecharge.getRechargeAmount());
                    dto.setPayerNumber(airtimeRecharge.getPayerNumber());
                    dto.setPaymentMethod(airtimeRecharge.getPaymentMethod());
                    return dto;
                });
    }

    @Override
    public Collection<AirtimeRechargeDto> findAllAirtimeRecharges() {
        Collection<AirtimeRecharge> airtimeRecharges = findAll();
        Collection<AirtimeRechargeDto> airtimeRechargeDtos = new ArrayList<>();
        airtimeRecharges.forEach(airtimeRecharge ->
                airtimeRechargeDtos.add(airtimeRechargeMapper.airtimeRechargeDtoFromAirtimeRecharge(airtimeRecharge)));
        return airtimeRechargeDtos;
    }
}
