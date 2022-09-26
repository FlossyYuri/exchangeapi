package mz.co.exchangerate.exchangeapi.currency.service;

import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.ExchangeCurrency;

import java.util.List;

public interface CurrencyService {
    void create(CurrencyUpdateDTO currency);
    void update(Integer id,CurrencyUpdateDTO currency);
    void deleteById(Integer id);
    List<Currency> findAll();
    Currency findOne(Integer id);
    Currency findByCode(String name);

    ExchangeCurrency fetchRemoteCurrencies();
}
