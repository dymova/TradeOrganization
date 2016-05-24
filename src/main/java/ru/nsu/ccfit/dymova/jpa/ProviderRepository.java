package ru.nsu.ccfit.dymova.jpa;

import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.nsu.ccfit.dymova.entities.Provider;

/**
 * Created by nastya on 24.05.16.
 */
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByName(String name);
}
