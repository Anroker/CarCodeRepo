package pl.arcsoftware.carcoderepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arcsoftware.carcoderepo.models.newModels.CarEntity;
import pl.arcsoftware.carcoderepo.models.newModels.UsersEntity;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

//    List<CarEntity> findCarByUserOrderById(UsersEntity usersEntity);

}
