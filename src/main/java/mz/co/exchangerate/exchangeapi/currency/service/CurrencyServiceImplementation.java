package mz.co.exchangerate.exchangeapi.currency.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.domain.repository.CurrencyRepository;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.ExchangeCurrency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.SupportedCodesDTO;
import mz.co.exchangerate.exchangeapi.currency.rest.mapper.CurrencyMapper;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateCreateByCurrenciesCodeDTO;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImplementation  implements CurrencyService{
    private final CurrencyRepository currencyRepository;
    private final RateService rateService;
    private  final CurrencyMapper currencyMapper;
    @Override
    public void create(CurrencyUpdateDTO currency) {
        Currency createdCurrency = currencyMapper.toCurrency(currency);
        currencyRepository.save(createdCurrency);
    }

    @Override
    public void update(Integer id, CurrencyUpdateDTO dto) {
        System.out.println(dto);
        currencyRepository.findById(id).map(currency -> {
            Currency updatedCurrency = currencyMapper.toCurrency(dto);
            updatedCurrency.setId(currency.getId());
            System.out.println(updatedCurrency);
            currencyRepository.save(updatedCurrency);

            return currency;
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public void deleteById(Integer id) {
        currencyRepository.delete(findOne(id));
    }

    @Override
    public List<Currency> findAll() {
        List<Currency>currencies = new ArrayList<>();
        currencyRepository.findAll().forEach(currencies::add);
        return currencies;
    }

    @Override
    public Currency findOne(Integer id) {
        return currencyRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Currency findByCode(String name) {
        return currencyRepository.findByCode(name);
    }


    @Override
    public ExchangeCurrency fetchRemoteCurrencies() {
        ExchangeCurrency exchangeCurrency = fetchExchangeRate();
        SupportedCodesDTO supportedCodesDTO = fetchCurrencies();
        supportedCodesDTO.getSupported_codes().forEach(
                code ->{
                    Currency currency = new Currency();
                    currency.setCode(code.get(0));
                    currency.setName(code.get(1));
                    currencyRepository.save(currency);
                }
        );
        for (Map.Entry<String, Float> entry : exchangeCurrency.getConversion_rates().entrySet()) {
            RateCreateByCurrenciesCodeDTO rate = new RateCreateByCurrenciesCodeDTO();
            rate.setBase_currency("USD");
            rate.setTarget_currency(entry.getKey());
            rate.setConversion_rate(entry.getValue());
            rateService.createByCurrenciesCode(rate);
        }
        return exchangeCurrency;
    }
    private ExchangeCurrency fetchExchangeRate() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://v6.exchangerate-api.com/v6/56dd9f4595b91f15fd56fe16/latest/USD";
        ResponseEntity<ExchangeCurrency> response = restTemplate.getForEntity(url, ExchangeCurrency.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
    private SupportedCodesDTO fetchCurrencies() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://v6.exchangerate-api.com/v6/56dd9f4595b91f15fd56fe16/codes";
        ResponseEntity<SupportedCodesDTO> response = restTemplate.getForEntity(url, SupportedCodesDTO.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


}
