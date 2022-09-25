package mz.co.exchangerate.exchangeapi.pair.service;

import mz.co.exchangerate.exchangeapi.pair.rest.dto.PairResponseDTO;

public interface PairService {
    PairResponseDTO findRateByBaseCurrencyAndTargetCurrency(String base_code,String target_code);
}
