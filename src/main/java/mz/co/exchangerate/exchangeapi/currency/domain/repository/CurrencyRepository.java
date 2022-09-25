package mz.co.exchangerate.exchangeapi.currency.domain.repository;

import mz.co.exchangerate.exchangeapi.currency.domain.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency,Integer> {
    Currency findByCode(String name);
}