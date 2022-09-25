package mz.co.exchangerate.exchangeapi.rate.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("Get All Exchange Rates")
    public List<Rate> findAll(){
        return rateService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Get Exchange Rate by ID")
    public Rate findOne(@PathVariable @ApiParam("Rate ID") Integer id){
        return rateService.findById(id);
    }

    @GetMapping("/code/{base_code}")
    @ApiOperation("Get Rate by Base Currency Code")
    public List<Rate> findByCode(@PathVariable @ApiParam("Base Currency ID") String base_code){
        return rateService.findByBaseCurrencyCode(base_code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create a new Rate")
    public void create(@RequestBody RateCreateDTO currency){
        rateService.create(currency);
    }

    @PutMapping("{id}")
    @ApiOperation("Update Rate by ID")
    public void update(@PathVariable @ApiParam("Rate ID") Integer id, @RequestBody RateUpdateDTO dto){
        rateService.update(id, dto);
    }
}
