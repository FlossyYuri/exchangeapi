package mz.co.exchangerate.exchangeapi.rate.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.domain.repository.CurrencyRepository;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.domain.repository.RateRepository;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateCreateDTO;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateUpdateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateServiceImplementation implements RateService{
    private final RateRepository rateRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public void create(RateCreateDTO currency) {
        Integer idBaseCurrency = currency.getBase_currency();
        Integer idTargetCurrency = currency.getTarget_currency();

        Currency base_currency = currencyRepository.findById(idBaseCurrency).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Currency target_currency = currencyRepository.findById(idTargetCurrency).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        Rate rate = new Rate();
        rate.setBase_currency(base_currency);
        rate.setTarget_currency(target_currency);
        rate.setConversion_rate(currency.getConversion_rate());
        rateRepository.save(rate);
    }

    @Override
    public void update(Integer id, RateUpdateDTO dto) {
        rateRepository.findById(id).map(rate->{
            rate.setConversion_rate(dto.getConversion_rate());
            rateRepository.save(rate);
            return rate;
        }).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Rate findById(Integer id) {
        return rateRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    @Override
    public List<Rate> findByBaseCurrencyCode(String base_currency_code) {
        return rateRepository.findByBaseCurrencyCode(base_currency_code);
    }

}
