package mz.co.exchangerate.exchangeapi.currency.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import mz.co.exchangerate.exchangeapi.currency.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/currencies",name = "currencies")
@RequiredArgsConstructor
@Tag(name = "Currency", description = "Manipulate Currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    @Operation(description = "Get All Currencies")
    public List<Currency> findAll(){
        return currencyService.findAll();
    }

    @GetMapping("{id}")
    @Operation(description = "Get currency by ID")
    public Currency findOne(@PathVariable @Parameter(name = "id",description = "Currency ID") Integer id){
        return currencyService.findOne(id);
    }

    @GetMapping("/code/{code}")
    @Operation(description = "Get currency by Code")
    public Currency findByCode(@PathVariable @Parameter(name = "code",description = "Currency code") String code){
        return currencyService.findByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Save a new Currency")
    public void create(@Valid @RequestBody CurrencyUpdateDTO currency){
        currencyService.create(currency);
    }

    @PutMapping("{id}")
    @Operation(description = "Update Currency")

    public void update(@PathVariable @Parameter(name = "id",description = "Currency ID") Integer id, @Valid @RequestBody CurrencyUpdateDTO dto){
        currencyService.update(id, dto);
    }
}
