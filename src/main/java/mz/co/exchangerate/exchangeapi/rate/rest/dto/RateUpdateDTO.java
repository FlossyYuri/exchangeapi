package mz.co.exchangerate.exchangeapi.rate.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RateUpdateDTO {
    @NotBlank(message = "Conversion Rate Required")
    private Float conversion_rate;
}
