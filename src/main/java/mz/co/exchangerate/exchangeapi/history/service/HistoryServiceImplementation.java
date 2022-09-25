package mz.co.exchangerate.exchangeapi.history.service;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.history.domain.entity.History;
import mz.co.exchangerate.exchangeapi.history.domain.repository.HistoryRepository;
import mz.co.exchangerate.exchangeapi.history.rest.dto.HistoryCreateDTO;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImplementation implements HistoryService{
    private final HistoryRepository historyRepository;
    private final RateService rateService;

    @Override
    public History register(HistoryCreateDTO historyCreateDTO) {
        Rate rate = rateService.findById(historyCreateDTO.getRate());
        History history = new History();
        history.setRate(rate);
        historyRepository.save(history);
        return  history;
    }

    @Override
    public List<History> findByRateBaseCurrencyCode(String code) {
        return historyRepository.findByRateBaseCurrencyCode(code);
    }
}
