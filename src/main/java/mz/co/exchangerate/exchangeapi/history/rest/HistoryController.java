package mz.co.exchangerate.exchangeapi.history.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.history.domain.entity.History;
import mz.co.exchangerate.exchangeapi.history.rest.dto.HistoryCreateDTO;
import mz.co.exchangerate.exchangeapi.history.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/histories",name = "histories")
@RequiredArgsConstructor
@Tag(name = "History", description = "Manipulate history")
public class HistoryController {
    private final HistoryService historyService;
    @PostMapping
    @Operation(description = "Register a new History")
    public History create(@Valid @RequestBody HistoryCreateDTO history){
        return historyService.register(history);
    }

    @GetMapping("{code}")
    @Operation(description = "Get History by Base Currency Code")
    public List<History> findAll(@PathVariable @Parameter(name = "code",description = "Base Currency Code") String code){
        return historyService.findByRateBaseCurrencyCode(code);
    }
}
