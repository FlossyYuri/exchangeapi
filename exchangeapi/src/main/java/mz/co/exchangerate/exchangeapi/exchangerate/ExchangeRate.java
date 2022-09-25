package mz.co.exchangerate.exchangeapi.exchangerate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeRate {
    @Id
    private final String base_code;

    private String currency;

    public ExchangeRate(String base_code, String currency) {
        this.base_code = base_code;
        this.currency = currency;
    }

    public ExchangeRate() {
        this.base_code = "USD";
    }

    public String getBase_code() {
        return base_code;
    }

    public String getCurrency() {
        return currency;
    }
}
