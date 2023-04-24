/*
package pl.arcsoftware.carcoderepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.arcsoftware.carcoderepo.models.newModels.CarEntity;
import pl.arcsoftware.carcoderepo.models.newModels.FuelNoteEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;*/
/**//*


@Repository
public interface FuelNotesRepository extends JpaRepository<FuelNoteEntity, Long> {

    */
/*List<FuelNoteEntity> findFuelNotesByCreatedDateAfterAndCreatedDateBefore(LocalDateTime after, LocalDateTime before);

    List<FuelNoteEntity> findFuelNotesByCreatedDateAfterAndCreatedDateBeforeAndCar(LocalDateTime after, LocalDateTime before, CarEntity car);
*//*

    @Query("SELECT AVG(f.fuel) from FuelNoteEntity f where f.carId = :car")
    Double avgFuel(@Param("car") CarEntity car);

    @Query("select AVG(f.distance) from FuelNoteEntity f where f.carId = :car")
    BigDecimal avgDistance(@Param("car") CarEntity car);
}*/
