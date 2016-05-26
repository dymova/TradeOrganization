package ru.nsu.ccfit.dymova.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    Consumer findByName(String name);
}
