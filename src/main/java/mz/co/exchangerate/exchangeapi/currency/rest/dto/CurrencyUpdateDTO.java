package mz.co.exchangerate.exchangeapi.currency.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyUpdateDTO {
    private String name;
    private String code;
}
