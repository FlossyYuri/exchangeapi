package mz.co.exchangerate.exchangeapi.currency.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyUpdateDTO {
    @NotBlank(message = "Currency Name required")
    private String name;
    @NotEmpty(message = "Currency Code required")
    private String code;
}
