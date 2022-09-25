package mz.co.exchangerate.exchangeapi.rate.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;

import javax.persistence.*;

@Entity
@Table(name = "rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    private Currency base_currency;
    @OneToOne(fetch = FetchType.EAGER)
    private Currency target_currency;
    private Float conversion_rate;

}
