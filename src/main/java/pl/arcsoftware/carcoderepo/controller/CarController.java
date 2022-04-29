package pl.arcsoftware.carcoderepo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.payload.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.payload.response.CarResponse;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.security.services.UserDetailsImpl;

import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarController(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(Authentication principal) {

        UserDetailsImpl userDetails = (UserDetailsImpl) principal.getPrincipal();

        return ResponseEntity.ok("userName: " + userDetails.getUsername() + " UserID: " + userDetails.getId());
    }

    @PostMapping("/addCar")
    public ResponseEntity<?> addCarToUser(Authentication authentication, @RequestBody CarRequest carRequest) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

        Car car = new Car();

        car.setEngine(carRequest.getEngine());
        car.setModel(carRequest.getModel());

        car.setUser(user.get());

        carRepository.save(car);

        return ResponseEntity.ok(new CarResponse(
                        "success",
                        carRequest.getModel(),
                        carRequest.getEngine()
                )
        );

    }
}
