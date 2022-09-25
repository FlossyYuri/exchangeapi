package mz.co.exchangerate.exchangeapi.pair.rest.dto;

import lombok.Data;

@Data
public class PairResponseDTO {
    private  String base_code;
    private  String target_code;
    private Float conversion_rate;
}
