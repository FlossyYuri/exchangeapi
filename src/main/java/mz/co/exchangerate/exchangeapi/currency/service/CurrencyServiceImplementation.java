package mz.co.exchangerate.exchangeapi.currency.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.domain.repository.CurrencyRepository;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import mz.co.exchangerate.exchangeapi.currency.rest.mapper.CurrencyMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImplementation  implements CurrencyService{
    private final CurrencyRepository currencyRepository;
    @Override
    public void create(CurrencyUpdateDTO currency) {
        Currency createdCurrency = CurrencyMapper.INSTANCE.toCurrency(currency);
        currencyRepository.save(createdCurrency);
    }

    @Override
    public void update(Integer id, CurrencyUpdateDTO dto) {
        System.out.println(dto);
        currencyRepository.findById(id).map(currency -> {
            Currency updatedCurrency = CurrencyMapper.INSTANCE.toCurrency(dto);
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
}
