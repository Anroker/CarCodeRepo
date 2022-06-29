package pl.arcsoftware.carcoderepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.FuelNotes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FuelNotesRepository extends JpaRepository<FuelNotes, Long> {

    List<FuelNotes> findFuelNotesByCreatedDateAfterAndCreatedDateBefore(LocalDateTime after, LocalDateTime before);

    List<FuelNotes> findFuelNotesByCreatedDateAfterAndCreatedDateBeforeAndCar(LocalDateTime after, LocalDateTime before, Car car);

    @Query("SELECT AVG(f.fuel) from FuelNotes f where f.car = :car")
    Double avgFuel(@Param("car") Car car);

    @Query("select AVG(f.distance) from FuelNotes f where f.car = :car")
    BigDecimal avgDistance(@Param("car") Car car);
}