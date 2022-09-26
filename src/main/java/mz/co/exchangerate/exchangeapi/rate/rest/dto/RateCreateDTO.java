package mz.co.exchangerate.exchangeapi.rate.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RateCreateDTO {
    @NotBlank(message = "Base currency ID Required")
    private Integer base_currency;
    @NotBlank(message = "Target currency ID Required")
    private Integer target_currency;
    @NotBlank(message = "Conversion Rate Required")
    private Float conversion_rate;
}
