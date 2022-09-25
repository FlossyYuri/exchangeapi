package mz.co.exchangerate.exchangeapi.currency.rest.mapper;

import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    Currency toCurrency(CurrencyUpdateDTO currencyUpdateDTO);
}
