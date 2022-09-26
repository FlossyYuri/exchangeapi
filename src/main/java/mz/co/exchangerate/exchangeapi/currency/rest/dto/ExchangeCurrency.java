package mz.co.exchangerate.exchangeapi.currency.rest.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ExchangeCurrency implements Serializable {
    private String result;
    private String base_code;
    private Map<String,Float> conversion_rates;
}
