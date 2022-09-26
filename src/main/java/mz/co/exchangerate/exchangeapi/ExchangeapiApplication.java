package mz.co.exchangerate.exchangeapi;

import lombok.RequiredArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RequiredArgsConstructor
public class ExchangeapiApplication {


	@Bean
	public CommandLineRunner commandLineRunner(@Autowired CurrencyService currencyService){
		return args -> {
			currencyService.fetchRemoteCurrencies();
		};
	}


	public static void main(String[] args) {

	    SpringApplication.run(ExchangeapiApplication.class, args);

	}

}
