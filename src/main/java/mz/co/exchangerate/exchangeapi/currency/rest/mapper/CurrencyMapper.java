package mz.co.exchangerate.exchangeapi.currency.rest.mapper;


import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CurrencyMapper {
    public static final CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);
    public abstract Currency toCurrency(CurrencyUpdateDTO currencyUpdateDTO);
}
