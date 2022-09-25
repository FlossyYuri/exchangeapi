package mz.co.exchangerate.exchangeapi.latest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/latest")
public class LatestController {

    @GetMapping("/{base_code}")
    public String getLatest(@PathVariable String base_code){
        System.out.println("here"+base_code);
        return base_code;
    }
}
