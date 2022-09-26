package mz.co.exchangerate.exchangeapi.rate.rest.dto;

import lombok.Data;

@Data
public class RateCreateByCurrenciesCodeDTO {
    private String base_currency;
    private String target_currency;
    private Float conversion_rate;
}
