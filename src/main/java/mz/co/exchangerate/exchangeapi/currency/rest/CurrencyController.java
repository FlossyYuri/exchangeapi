package mz.co.exchangerate.exchangeapi.currency.rest;

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
    public List<Currency> findAll(){
        return currencyService.findAll();
    }

    @GetMapping("{id}")
    public Currency findOne(@PathVariable Integer id){
        return currencyService.findOne(id);
    }

    @GetMapping("/code/{code}")
    public Currency findByCode(@PathVariable String code){
        return currencyService.findByCode(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CurrencyUpdateDTO currency){
        currencyService.create(currency);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody CurrencyUpdateDTO dto){
        currencyService.update(id, dto);
    }
}
