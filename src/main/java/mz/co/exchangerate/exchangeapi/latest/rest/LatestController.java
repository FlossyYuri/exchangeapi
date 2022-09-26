package mz.co.exchangerate.exchangeapi.latest.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.latest.rest.dto.LatestResponseDTO;
import mz.co.exchangerate.exchangeapi.latest.service.LatestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/latest",name = "latest")
@RequiredArgsConstructor
@Tag(name = "Latest", description = "Manipulate Latest")
public class LatestController {
    private final LatestService latestService;

    @GetMapping("{code}")
    @Operation(description = "Get Latest Exchange Rate By Base Currency Code")
    public LatestResponseDTO findByCode(@PathVariable @Parameter(name = "code",description = "Currency Code") String code){
        return latestService.findByCode(code);
    }
}
