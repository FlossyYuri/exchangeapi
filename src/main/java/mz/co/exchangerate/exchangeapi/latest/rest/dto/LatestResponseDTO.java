package mz.co.exchangerate.exchangeapi.latest.rest.dto;

import lombok.Data;

import java.util.Map;

@Data
public class LatestResponseDTO {
    private String result;
    private String base_code;
    private Map<String,Float> conversion_rates;
}
