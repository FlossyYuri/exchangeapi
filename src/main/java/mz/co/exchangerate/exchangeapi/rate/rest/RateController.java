package mz.co.exchangerate.exchangeapi.rate.rest;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateCreateDTO;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateUpdateDTO;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rate",name = "rate")
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @GetMapping
    public List<Rate> findAll(){
        return rateService.findAll();
    }

    @GetMapping("{id}")
    public Rate findOne(@PathVariable Integer id){
        return rateService.findById(id);
    }

    @GetMapping("/code/{base_code}")
    public List<Rate> findByCode(@PathVariable String base_code){
        return rateService.findByBaseCurrencyCode(base_code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody RateCreateDTO currency){
        rateService.create(currency);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, @RequestBody RateUpdateDTO dto){
        rateService.update(id, dto);
    }
}
