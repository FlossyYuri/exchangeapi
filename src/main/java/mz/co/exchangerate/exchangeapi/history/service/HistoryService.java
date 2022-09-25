package mz.co.exchangerate.exchangeapi.history.service;

import mz.co.exchangerate.exchangeapi.history.domain.entity.History;
import mz.co.exchangerate.exchangeapi.history.rest.dto.HistoryCreateDTO;

import java.util.List;

public interface HistoryService {
    History register(HistoryCreateDTO historyCreateDTO);
    List<History> findByRateBaseCurrencyCode(String code);
}
