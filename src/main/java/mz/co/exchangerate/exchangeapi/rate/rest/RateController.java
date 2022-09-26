package mz.co.exchangerate.exchangeapi.rate.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateCreateDTO;
import mz.co.exchangerate.exchangeapi.rate.rest.dto.RateUpdateDTO;
import mz.co.exchangerate.exchangeapi.rate.service.RateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rate",name = "rate")
@RequiredArgsConstructor
@Tag(name = "Exchange Rate", description = "Manipulate Rate")
public class RateController {

    private final RateService rateService;

    @GetMapping
    @Operation(description = "Get All Exchange Rates")
    public List<Rate> findAll(){
        return rateService.findAll();
    }

    @GetMapping("{id}")
    @Operation(description = "Get Exchange Rate by ID")
    public Rate findOne(@PathVariable @Parameter(name = "id",description = "Rate ID") Integer id){
        return rateService.findById(id);
    }

    @GetMapping("/code/{base_code}")
    @Operation(description = "Get Rate by Base Currency Code")
    public List<Rate> findByCode(@PathVariable @Parameter(name = "code",description = "Base Currency Code") String base_code){
        return rateService.findByBaseCurrencyCode(base_code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create a new Rate")
    public void create(@Valid @RequestBody RateCreateDTO currency){
        rateService.create(currency);
    }

    @PutMapping("{id}")
    @Operation(description = "Update Rate by ID")
    public void update(@PathVariable @Parameter(name = "id",description = "Rate ID") Integer id, @Valid @RequestBody RateUpdateDTO dto){
        rateService.update(id, dto);
    }
}
