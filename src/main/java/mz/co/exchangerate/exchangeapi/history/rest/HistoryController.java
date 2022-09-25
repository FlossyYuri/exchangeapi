package mz.co.exchangerate.exchangeapi.history.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("Register a new History")
    public History create(@RequestBody HistoryCreateDTO history){
        return historyService.register(history);
    }

    @GetMapping("{code}")
    @ApiOperation("Get History by Base Currency Code")
    public List<History> findAll(@PathVariable @ApiParam("Base Currency code") String code){
        return historyService.findByRateBaseCurrencyCode(code);
    }
}
