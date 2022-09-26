package mz.co.exchangerate.exchangeapi.pair.rest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Pair", description = "Manipulate Pair")
public class PairController {
    private final PairService pairService;
    @GetMapping("{base_code}/{target_code}")
    public PairResponseDTO rate(@PathVariable @Parameter(name = "base_code",description = "Base Currency Code") String base_code,
                                @PathVariable @Parameter(name = "target_code",description = "Target Currency Code") String target_code){
        return pairService.findRateByBaseCurrencyAndTargetCurrency(base_code,target_code);
    }
}
