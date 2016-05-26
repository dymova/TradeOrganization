package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Good;
import ru.nsu.ccfit.dymova.entities.Sale;

import java.util.Date;
import java.util.List;


public interface SaleRepository extends JpaRepository<Sale, Long>{

    List<Sale> findByGoodAndCountLessThanAndDateBetween(Good good, Integer count, Date date1, Date date2);
}
