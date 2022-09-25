package mz.co.exchangerate.exchangeapi.rate.domain.repository;

import mz.co.exchangerate.exchangeapi.rate.domain.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate,Integer> {

    @Query(value = "select r from Rate r left join fetch r.base_currency where r.base_currency.code = :code")
    List<Rate> findByBaseCurrencyCode(@Param("code") String code);
}
