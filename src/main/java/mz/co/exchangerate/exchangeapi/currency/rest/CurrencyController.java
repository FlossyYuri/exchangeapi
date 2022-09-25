package mz.co.exchangerate.exchangeapi.currency.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import mz.co.exchangerate.exchangeapi.currency.rest.dto.CurrencyUpdateDTO;
import mz.co.exchangerate.exchangeapi.currency.service.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/currencies",name = "currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    @ApiOperation("Get All Currencies")
    public List<Currency> findAll(){
        return currencyService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Get currency by ID")
    public Currency findOne(@PathVariable @ApiParam("Currency ID") Integer id){
        return currencyService.findOne(id);
    }

    @GetMapping("/code/{code}")
    @ApiOperation("Get currency by Code")
    public Currency findByCode(@PathVariable @ApiParam("Currency Code") String code){
        return currencyService.findByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Save a new Currency")
    public void create(@RequestBody CurrencyUpdateDTO currency){
        currencyService.create(currency);
    }

    @PutMapping("{id}")
    @ApiOperation("Update Currency")

    public void update(@PathVariable @ApiParam("Currency ID") Integer id, @RequestBody CurrencyUpdateDTO dto){
        currencyService.update(id, dto);
    }
}
