package pl.arcsoftware.carcoderepo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.models.UserDTO;
import pl.arcsoftware.carcoderepo.services.UserServiceImpl;

@RestController
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public User saveUser(@RequestBody UserDTO user){

       return userService.save(user);
    }
}
