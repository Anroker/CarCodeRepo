package pl.arcsoftware.carcoderepo.services;

import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.models.UserDTO;

import java.util.List;

public interface UserService {
    User save(UserDTO user);
    List<User> findAll();
    void delete(Long id);
    User findOne(String username);
    User findById(Long id);


}
