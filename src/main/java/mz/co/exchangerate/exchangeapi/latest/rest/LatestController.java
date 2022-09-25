package mz.co.exchangerate.exchangeapi.latest.rest;

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
public class LatestController {
    private final LatestService latestService;

    @GetMapping("{code}")
    public LatestResponseDTO findByCode(@PathVariable String code){
        return latestService.findByCode(code);
    }
}
