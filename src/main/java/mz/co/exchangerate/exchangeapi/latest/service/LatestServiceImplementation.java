package mz.co.exchangerate.exchangeapi.latest.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.latest.rest.dto.LatestResponseDTO;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LatestServiceImplementation implements LatestService {
    private  final RateService rateService;

    @Override
    public LatestResponseDTO findByCode(String code) {
        List<Rate> rates = rateService.findByBaseCurrencyCode(code);
        LatestResponseDTO latestResponseDTO = new LatestResponseDTO();
        latestResponseDTO.setBase_code(code);
        latestResponseDTO.setResult("success");
        Map<String,Float> conversion_rates = new LinkedHashMap<>();
        rates.forEach(rate->{
            conversion_rates.put(rate.getTarget_currency().getCode(),rate.getConversion_rate());
        });
        latestResponseDTO.setConversion_rates(conversion_rates);
        return latestResponseDTO;
    }
}
