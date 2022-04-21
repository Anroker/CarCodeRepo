package pl.arcsoftware.carcoderepo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.arcsoftware.carcoderepo.models.User;

@Repository
public interface  UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
