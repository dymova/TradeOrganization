package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.TradingPlace;
import ru.nsu.ccfit.dymova.entities.TradingPlaceType;


public interface TradingPlaceRepository extends JpaRepository<TradingPlace, Long>{

    TradingPlace findByNameAndTypeId(String name, Long id);

    TradingPlace findByName(String tradingPlaceName);
}
