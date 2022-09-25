package mz.co.exchangerate.exchangeapi.rate.rest.dto;

import lombok.Data;

@Data
public class RateCreateDTO {
    private Integer base_currency;
    private Integer target_currency;
    private Float conversion_rate;
}
