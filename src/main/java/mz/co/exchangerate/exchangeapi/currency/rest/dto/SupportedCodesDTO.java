package mz.co.exchangerate.exchangeapi.currency.rest.dto;

import lombok.Data;

import java.util.List;

@Data
public class SupportedCodesDTO {
    private List<List<String>> supported_codes;
}
