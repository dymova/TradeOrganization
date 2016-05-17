package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.TradingPlaceType;

/**
 * Created by nastya on 16.05.16.
 */
public interface TradingPlaceTypeRepository extends JpaRepository<TradingPlaceType, Long> {
    TradingPlaceType findByName(String name);
}
