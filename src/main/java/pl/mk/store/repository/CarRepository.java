package pl.mk.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mk.store.model.Car;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByNrVin(String nrVin);
}
