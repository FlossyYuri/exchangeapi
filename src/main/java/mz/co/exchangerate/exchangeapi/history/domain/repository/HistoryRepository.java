package mz.co.exchangerate.exchangeapi.history.domain.repository;

import mz.co.exchangerate.exchangeapi.history.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query(value = "select h from History h left join fetch h.rate where h.rate.base_currency.code = :code")

    List<History> findByRateBaseCurrencyCode(String code);
}
