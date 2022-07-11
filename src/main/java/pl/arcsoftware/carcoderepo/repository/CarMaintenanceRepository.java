package pl.arcsoftware.carcoderepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import pl.arcsoftware.carcoderepo.models.CarMaintenance;

@Repository
public interface CarMaintenanceRepository extends JpaRepository<CarMaintenance, Long> {

}