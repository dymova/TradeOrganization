package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Good;

/**
 * Created by nastya on 24.05.16.
 */
public interface GoodRepository extends JpaRepository<Good, Long> {
    Good findByName(String goodName);
}
