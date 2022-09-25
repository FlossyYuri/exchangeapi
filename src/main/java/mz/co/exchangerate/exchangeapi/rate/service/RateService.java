package mz.co.exchangerate.exchangeapi.rate.service;

import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateCreateDTO;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateUpdateDTO;

import java.util.List;

public interface RateService {
    void create(RateCreateDTO currency);
    void update(Integer id, RateUpdateDTO dto);
    Rate findById(Integer id);
    List<Rate> findAll();
    List<Rate> findByBaseCurrencyCode(String base_currency_code);
//    Rate findByBaseCurrencyCodeAndTargetCurrencyCode(String base_currency,String target_currency);
}
