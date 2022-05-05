package pl.arcsoftware.carcoderepo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.arcsoftware.carcoderepo.models.Car;
import pl.arcsoftware.carcoderepo.models.User;
import pl.arcsoftware.carcoderepo.payload.request.car.CarRequest;
import pl.arcsoftware.carcoderepo.payload.response.MessageResponse;
import pl.arcsoftware.carcoderepo.payload.response.car.CarResponse;
import pl.arcsoftware.carcoderepo.repository.CarRepository;
import pl.arcsoftware.carcoderepo.repository.UserRepository;
import pl.arcsoftware.carcoderepo.security.services.UserDetailsImpl;

import java.util.List;
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

    @GetMapping("/getCar/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);

        if (car.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cant find car by id!"));
        }

        return ResponseEntity.ok(new CarResponse(
                "success",
                car.get().getModel(),
                car.get().getEngine()
        ));

    }

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars(Authentication authentication) {

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Optional<User> user = userRepository.findById(userDetails.getId());

        List<Car> carList = carRepository.findCarByUser(user.get());

        return ResponseEntity.ok(carList);
    }
}
