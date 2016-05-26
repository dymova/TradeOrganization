package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Delivery;
import ru.nsu.ccfit.dymova.entities.Good;

import java.util.Date;
import java.util.List;

/**
 * Created by nastya on 16.05.16.
 */
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findProviderByGoodAndCountAndDateBetween(Good good, Integer count, Date date1, Date date2);

    List<Delivery> findByGoodAndProviderAndDateBetween(Long goodId, Long providerId, Date date1, Date date2);
}
