package mz.co.exchangerate.exchangeapi.pair.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.pair.rest.dto.PairResponseDTO;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PairServiceImplementation implements  PairService{
    private  final RateService rateService;
    @Override
    public PairResponseDTO findRateByBaseCurrencyAndTargetCurrency(String base_code, String target_code) {
        Rate rate = rateService.findRateByBaseCurrencyAndTargetCurrency(base_code,target_code);
        PairResponseDTO pairResponseDTO = new PairResponseDTO();
        pairResponseDTO.setBase_code(rate.getBase_currency().getCode());
        pairResponseDTO.setTarget_code(rate.getTarget_currency().getCode());
        pairResponseDTO.setConversion_rate(rate.getConversion_rate());
        return pairResponseDTO;
    }
}
