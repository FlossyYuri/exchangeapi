package mz.co.exchangerate.exchangeapi.history.rest;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.history.domain.entity.History;
import mz.co.exchangerate.exchangeapi.history.rest.dto.HistoryCreateDTO;
import mz.co.exchangerate.exchangeapi.history.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/histories",name = "histories")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;
    @PostMapping
    public History create(@RequestBody HistoryCreateDTO history){
        return historyService.register(history);
    }

    @GetMapping("{code}")
    public List<History> findAll(@PathVariable String code){
        return historyService.findByRateBaseCurrencyCode(code);
    }
}
