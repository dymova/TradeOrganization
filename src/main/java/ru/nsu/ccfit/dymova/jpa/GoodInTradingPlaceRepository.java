package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Good;
import ru.nsu.ccfit.dymova.entities.GoodInTradingPlace;
import ru.nsu.ccfit.dymova.entities.TradingPlace;

import java.util.List;

/**
 * Created by nastya on 24.05.16.
 */
public interface GoodInTradingPlaceRepository  extends JpaRepository<GoodInTradingPlace, Long>{
    List<GoodInTradingPlace> findByTradingPlace(TradingPlace one);
}
