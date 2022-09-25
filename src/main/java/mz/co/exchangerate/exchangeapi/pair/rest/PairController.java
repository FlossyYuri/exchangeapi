package mz.co.exchangerate.exchangeapi.pair.rest;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.pair.rest.dto.PairResponseDTO;
import mz.co.exchangerate.exchangeapi.pair.service.PairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "pair",path = "/pair")
@RequiredArgsConstructor
public class PairController {
    private final PairService pairService;
    @GetMapping("{base_code}/{target_code}")
    public PairResponseDTO rate(@PathVariable String base_code,@PathVariable String target_code){
        return pairService.findRateByBaseCurrencyAndTargetCurrency(base_code,target_code);
    }
}
